var i = 0;
var request = new XMLHttpRequest();
var allOrders = [];
var filterOrders = [];
var noDataWarning = "<div class='alert alert-warning'> No data</div>";
var ordersMap = new Map();
var orderIdToDelete= null;
function createOrder(order){
    var url = 'http://localhost:8080/orders/createOrders';
    $.ajax({
        type: "PUT",
        contentType : 'application/json; charset=UTF-8',
        url: url,
        data: JSON.stringify({
            orderInfo: order.orderInfo,
            orderDetails: order.orderDetails
        })
    });
}
function deleteOrder(){
    console.log(orderIdToDelete + 'delete');
    var url = 'http://localhost:8080/orders/deleteOrders';
    $.ajax({
        type: "DELETE",
        contentType : 'application/json; charset=UTF-8',
        url: url,
        data: JSON.stringify({
            orderId: orderIdToDelete
        })
    });
    orderIdToDelete=null;
    $('#orderRemoveModal').modal('hide');
}
 //$("#deleteButton").on("click", deleteOrder());
$("#supertable").on("click", function(){
    console.log('nanan');
});

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
function openOrderModal(orderId) {
    var order = ordersMap.get(orderId);
    $('#idOrder').val(order.id);
    $('#customerId').val(order.customerId);
    $('#employeeId').val(order.employeeId);
    $('#orderDate').val(order.orderDate);
    $('#requiredDate').val(order.requiredDate);
    $('#shipVia').val(order.shipVia);
    $('#freight').val(order.freight);
    $('#shipName').val(order.shipName);
    $('#shipAdress').val(order.shipAdress);
    $('#shipCity').val(order.shipCity);
    $('#shipRegion').val(order.shipRegion);
    $('#shipPostalCode').val(order.shipPostalCode);
    $('#shipCountry').val(order.shipCountry);
    $('#orderModal').modal('show');
}
function openOrderDetailsModal(orderId) {
    var order = ordersMap.get(orderId);
    $('#idOrderD').html(order.orderId);
    $('#orderDateD').html(order.orderDate);
    $('#requiredDateD').html(order.requiredDate);
    $('#shippedDateD').html(order.shippedDate);
    $('#freightD').html(order.freight);
    $('#shipNameD').html(order.shipName);
    $('#shipAddressD').html(order.shipAddress);
    $('#shipCityD').html(order.shipCity);
    $('#shipRegionD').html(order.shipRegion);
    $('#shipPostalCodeD').html(order.shipPostalCode);
    $('#shipCountryD').html(order.shipCountry);
    var products = '';
    for(i=0;i<order.orderDetails.length;i++){
        products = products + '<tr><td>'+ order.orderDetails[i].productId +'</td><td>'+order.orderDetails[i].unitPrice+'</td><td>'+order.orderDetails[i].quantity+'</td><td>'+order.orderDetails[i].discount+'</td></tr>'
    }
    document.getElementById('detailsTableBody').innerHTML = products;
    $('#orderDetailsModal').modal('show');
}
function openOrderCreateModal() {
    loadProductsToNewOrder('productsTableBodyModalOrder');
    $('#orderCreateModal').modal('show');
}
function openOrderRemoveModal(id) {
    orderIdToDelete = id;
    $('#orderRemoveModal').modal('show');
}
function loadOrders(ordersList){
    ordersMap = new Map();
    for (i = 0; i < ordersList.length; i++) {
        ordersMap.set(ordersList[i].id, ordersList[i]);
    }
    var orderTable = document.getElementById('ordersTableBody');
    var text = '';
    for (i = 0; i < ordersList.length; i++) {
        text = text + "<tr><th>" + ordersList[i].orderId + "</th><td>" + ordersList[i].shipCountry + "</td><td>" + ordersList[i].shipName + "</td><td>" + ordersList[i].orderDate + "</td><td>" + ordersList[i].requiredDate + "</td><td>" + ordersList[i].shippedDate + "</td><td class='buttonTd'><button type=\"button\" class=\"m_right_7 btn btn-secondary btn-sm\" onclick=\"openOrderDetailsModal(" + ordersList[i].id + ")\">Details</button><button type=\"button\" class=\"m_right_7 btn btn-primary btn-sm\" onclick=\"openOrderModal(" + ordersList[i].id + ")\">\n" +
            "            Edit</button><button type=\"button\" class=\"btn btn-danger btn-sm\" onclick=\"openOrderRemoveModal("+ordersList[i].orderId+")\">X</button></td></tr>";
    }
    orderTable.innerHTML = text;
}
function filterOrdersFun(type){
    var filterValue = document.getElementById('ordersInputSearch').value;
    if(filterValue === ''){
        getAllOrders();
    }else{
        switch(type){
            case 1:
                getOrdersById(filterValue);
                break;
            case 2:
                getOrdersByCountry(filterValue);
                break;
            default:
                break;
        }

    }
}

getAllOrders();

