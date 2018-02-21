var allProducts = [];
var allOrders = [];
var filterOrders = [];
var filterProducts = [];
var allEmployees = [];
var allCustomers = [];
var noDataWarning = "<div class='alert alert-warning'> No data</div>";
var i=0;
var ordersMap = new Map();
var productsMap = new Map();
var employeesMap = new Map();
var customersMap = new Map();
var orderIdToDelete= null;
var productToDelete = null;
function getAllProducts () {
    var url = 'http://localhost:8080/products/readProducts';
    $.ajax({
        type: "POST",
        contentType : 'application/json; charset=UTF-8',
        url: url,
        success: function (res) {
            allProducts = res;
            productsMap = new Map();
            for (i = 0; i < allProducts.length; i++) {
                productsMap.set(allProducts[i].productId, allProducts[i]);
            }
            loadProducts(allProducts);
        },
        data: JSON.stringify({
        })
    });
}
function getAllOrders () {
    var url = 'http://localhost:8080/orders/readOrders';
    $.ajax({
        type: "POST",
        contentType : 'application/json; charset=UTF-8',
        url: url,
        success: function (res) {
            allOrders = res;
            loadOrders(allOrders);
        },
        data: JSON.stringify({
        })
    });

}
function loadOrders(ordersList){
    ordersMap = new Map();
    for (i = 0; i < ordersList.length; i++) {
        ordersMap.set(ordersList[i].id, ordersList[i]);
    }
    var orderTable = document.getElementById('ordersTableBody');
    var text = '';
    for (i = 0; i < ordersList.length; i++) {
        text = text + "<tr><th>" + ordersList[i].orderId + "</th><td>" + ordersList[i].shipCountry + "</td><td>" + ordersList[i].shipName + "</td><td>" + ordersList[i].orderDate + "</td><td>" + ordersList[i].requiredDate + "</td><td>" + ordersList[i].shippedDate + "</td><td class='buttonTd'><button type=\"button\" class=\"m_right_7 btn btn-secondary btn-sm\" onclick=\"openOrderDetailsModal(" + ordersList[i].id + ")\">Details</button>" +
            "            <button type=\"button\" class=\"btn btn-danger btn-sm\" onclick=\"openOrderRemoveModal("+ordersList[i].orderId+")\">X</button></td></tr>";
    }
    orderTable.innerHTML = text;
}
function deleteOrder(){
    var url = 'http://localhost:8080/orders/deleteOrders';
    $.ajax({
        type: "DELETE",
        contentType : 'application/json; charset=UTF-8',
        url: url,
        data: JSON.stringify({
            orderId: orderIdToDelete
        }),
        success: function(){
            orderIdToDelete=null;
            getAllOrders();
            $('#orderRemoveModal').modal('hide');
        }
    });

}
function getOrdersById (id) {
    var url = 'http://localhost:8080/orders/readOrders';
    $.ajax({
        type: "POST",
        contentType : 'application/json; charset=UTF-8',
        url: url,
        success: function (res) {
            filterOrders = res;
            if(res.length == 0){
                document.getElementById('ordersTableBody').innerHTML = noDataWarning;
            }else {
                loadOrders(filterOrders);
            }

        },
        data: JSON.stringify({
            orderId: id
        })
    });
}
function getOrdersByCountry(country) {
    var url = 'http://localhost:8080/orders/readOrders';
    $.ajax({
        type: "POST",
        contentType : 'application/json; charset=UTF-8',
        url: url,
        success: function (res) {
            filterOrders = res;
            if(res.length == 0){
                document.getElementById('ordersTableBody').innerHTML = noDataWarning;
            }else {
                loadOrders(filterOrders);
            }

        },
        data: JSON.stringify({
            shipCountry: country
        })
    });
}
function getProductsById (id) {
    var url = 'http://localhost:8080/products/readProducts';
    $.ajax({
        type: "POST",
        contentType : 'application/json; charset=UTF-8',
        url: url,
        success: function (res) {
            filterProducts = res;
            if(res.length == 0){
                document.getElementById('productsTableBody').innerHTML = noDataWarning;
            }else {
                loadProducts(filterProducts);
            }

        },
        data: JSON.stringify({
            productId: id
        })
    });
}
function getProductsByName(name) {
    var url = 'http://localhost:8080/products/readProducts';
    $.ajax({
        type: "POST",
        contentType : 'application/json; charset=UTF-8',
        url: url,
        success: function (res) {
            filterProducts = res;
            if(res.length == 0){
                document.getElementById('ordersTableBody').innerHTML = noDataWarning;
            }else {
                loadProducts(filterProducts);
            }

        },
        data: JSON.stringify({
            productName: name
        })
    });
}
function loadProducts(productToDisplay) {
    var productTable = document.getElementById('productsTableBody');
    var text = '';
    for (i = 0; i < productToDisplay.length; i++) {
        text = text + "<tr><th>" + productToDisplay[i].productId + "</th><td>" + productToDisplay[i].productName + "</td><td>" + productToDisplay[i].quantityPerUnit + "</td><td>" + productToDisplay[i].unitPrice + "</td>" +
            "<td><button type=\"button\" class=\"btn btn-primary btn-sm\" onclick=\"openProductDetailModal("+productToDisplay[i].productId+")\">Details</button></td>";
    }
    productTable.innerHTML = text;
}
function getAllEmployees () {
    var url = 'http://localhost:8080/employees/readEmployees';
    $.ajax({
        type: "POST",
        contentType : 'application/json; charset=UTF-8',
        url: url,
        success: function (res) {
            allEmployees = res;
            employeesMap = new Map();
            for (i = 0; i < allEmployees.length; i++) {
                employeesMap.set(allEmployees[i].employeeId, allEmployees[i]);
            }
            loadEmployees();
        },
        data: JSON.stringify({
        })
    });
}
function getAllCustomers () {
    var url = 'http://localhost:8080/customers/readCustomers';
    $.ajax({
        type: "POST",
        contentType : 'application/json; charset=UTF-8',
        url: url,
        success: function (res) {
            allCustomers = res;
            customersMap = new Map();
            for (i = 0; i < allEmployees.length; i++) {
                customersMap.set(allCustomers[i].customerID, customersMap[i]);
            }
            loadCustomers();
        },
        data: JSON.stringify({
        })
    });
}
function loadEmployees () {
    var employeesSelect = document.getElementById('employeeC');
    var text = '';
    for (i=0;i<allEmployees.length;i++){
        text = text + "<option value=\""+allEmployees[i].employeeId+"\">"+allEmployees[i].firstName + " " + allEmployees[i].lastName +"</option>"
    }
    employeesSelect.innerHTML = text;
}
function loadCustomers () {
    var customersSelect = document.getElementById('customerC');
    var text = '';
    for (i=0;i<allCustomers.length;i++){
        text = text + "<option value=\""+allCustomers[i].customerID+"\">"+allCustomers[i].companyName +"</option>"
    }
    customersSelect.innerHTML = text;
}
