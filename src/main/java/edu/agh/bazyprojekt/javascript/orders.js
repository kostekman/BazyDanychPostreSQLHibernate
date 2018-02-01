var i = 0;
var orders = [
    {
        id: 1223,
        customerId: 'nanan',
        employeeId: 213432,
        orderDate: 22,
        requiredDate: 32,
        shippedDate: 23,
        shipVia: 23,
        freight: 32,
        shipName: 324114324,
        shipAdress: 0.3,
        shipCity: 'Krakow',
        shipRegion: 'Europa',
        shipPostalCode: '23eeqw',
        shipCountry: 'Polska'
    },
    {
        id: 1,
        customerId: 'nanan',
        employeeId: 213432,
        orderDate: 22,
        requiredDate: 32,
        shippedDate: 23,
        shipVia: 23,
        freight: 32,
        shipName: 324114324,
        shipAdress: 0.3,
        shipCity: 'Krakow',
        shipRegion: 'Europa',
        shipPostalCode: '23eeqw',
        shipCountry: 'Polska'
    },
    {
        id: 23,
        customerId: 'nanan',
        employeeId: 213432,
        orderDate: 22,
        requiredDate: 32,
        shippedDate: 23,
        shipVia: 23,
        freight: 32,
        shipName: 324114324,
        shipAdress: 0.3,
        shipCity: 'Krakow',
        shipRegion: 'Europa',
        shipPostalCode: '23eeqw',
        shipCountry: 'Polska'
    }
];

var ordersMap = new Map();
for (i = 0; i < orders.length; i++) {
    ordersMap.set(orders[i].id, orders[i]);
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
var orderTable = document.getElementById('ordersTableBody');

var text = '';
for (i = 0; i < orders.length; i++) {
    text = text + "<tr><th>" + orders[i].id + "</th><td>" + orders[i].customerId + "</td><td>" + orders[i].employeeId + "</td><td>" + orders[i].orderDate + "</td><td>" + orders[i].requiredDate + "</td><td>" + orders[i].shipVia + "</td><td>" + orders[i].freight + "</td><td>" + orders[i].shipName + "</td><td>" + orders[i].shipAdress + "</td><td>" + orders[i].shipCity + "</td><td>" + orders[i].shipRegion + "</td><td>" + orders[i].shipPostalCode + "</td><td>" + orders[i].shipCountry +"</td><td class='buttonTd'><button type=\"button\" class=\"m_right_7 btn btn-primary btn-sm\" onclick=\"openOrderModal(" + orders[i].id + ")\">\n" +
        "            Edit</button><button type=\"button\" class=\"btn btn-danger btn-sm\" onclick=\"openOrderRemoveModal()\">X</button></td>";
}
orderTable.innerHTML = text;
var request = new XMLHttpRequest();

function  getAllOrders () {
    var url = 'http://localhost:8080/readEmployees';
    // fetch(url)
    //     .then(function(data) {
    //         console.log(data);
    //         // Here you get the data to modify as you please
    //     });
    // $.post(url, function(data) {
    //     console.log(data);
    //     // Here you get the data to modify as you please
    // })
    $.ajax({
        type: "POST",
        contentType : 'application/json; charset=UTF-8',
        url: url,
        data: {
            "name":"test"
        },
        dataType:'JSON'

    });
}

getAllOrders();