var i = 0;
var request = new XMLHttpRequest();
var allOrders = [];
var filterOrders = [];
var noDataWarning = "<div class='alert alert-warning'> No data</div>";
function  getAllOrders () {
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
function  getOrdersById (id) {
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
function openOrderCreateModal() {
    loadProductsToNewOrder('productsTableBodyModalOrder');
    $('#orderCreateModal').modal('show');
}
function openOrderRemoveModal() {
    $('#orderRemoveModal').modal('show');
}
function loadOrders(ordersList){
    var ordersMap = new Map();
    for (i = 0; i < ordersList.length; i++) {
        ordersMap.set(ordersList[i].id, ordersList[i]);
    }
    var orderTable = document.getElementById('ordersTableBody');
    var text = '';
    for (i = 0; i < ordersList.length; i++) {
        text = text + "<tr><th>" + ordersList[i].orderId + "</th><td>" + ordersList[i].shipCountry + "</td><td>" + ordersList[i].shipName + "</td><td>" + ordersList[i].orderDate + "</td><td>" + ordersList[i].requiredDate + "</td><td>" + ordersList[i].shippedDate + "</td><td class='buttonTd'><button type=\"button\" class=\"m_right_7 btn btn-primary btn-sm\" onclick=\"openOrderModal(" + ordersList[i].id + ")\">\n" +
            "            Edit</button><button type=\"button\" class=\"btn btn-danger btn-sm\" onclick=\"openOrderRemoveModal()\">X</button></td>";
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

