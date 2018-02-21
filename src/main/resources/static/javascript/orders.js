var productIdTable =[];
var k = 0;
function createOrder(){
    var productForNewOrder =[];
    var element;
    for(k=0;k<productIdTable.length;k++){
        element = {
            productId: productIdTable[k],
            discount: 0,
            unitPrice: productsMap.get(productIdTable[k]).unitPrice,
            quantity: $("#"+productIdTable[k]).val()
        };
        productForNewOrder.push(element);
    }
    var order = {
        orderInfo: {
            orderDate: $("#orderDateC").val(),
            requiredDate: $("#requiredDateC").val(),
            freight: $("#freightC").val(),
            shipName: $("#shipNameC").val(),
            shipAddress: $("#shipAddressC").val(),
            shipCity: $("#shipCityC").val(),
            shipPostalCode: $("#shipPostalCodeC").val(),
            shipCountry: $("#shipCountryC").val(),
            shipRegion: $("#shipRegionC").val(),
            customer: customersMap.get($("#customerC").val()),
            employee: employeesMap.get($("#employeeC").val())

        },
        orderDetails: productForNewOrder
    };
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
    $('#orderCreateModal').modal('hide');
    getAllOrders();
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
    getAllEmployees();
    getAllCustomers();
    document.getElementById("selectedProduct").innerHTML = "";
    document.getElementById("selectNewProduct").innerHTML = "";
    $('#orderCreateModal').modal('show');
}
function addProduct(id){
    productIdTable.push(id);
    var product = productsMap.get(id);
    $("#selectedProduct").append("<div class=\"col-md-6\">"+product.productName+"</div><div class=\"col-md-6\" ><input id=\""+product.productId+"\" type='number'></div>");
}
function selectNewProductToOrder(){
    productIdTable = [];
    getAllProducts();
    var productDropdownText = '';

    for (var j=0; j<allProducts.length;j++){
        console.log(allProducts[j].productName);
        productDropdownText = productDropdownText + "<a class=\"dropdown-item\" onclick=\"addProduct("+allProducts[j].productId +")\">" + allProducts[j].productName + "</a>";
    }
    document.getElementById("selectNewProduct").innerHTML = "<div class=\"dropdown\">\n" +
        "  <button class=\"btn btn-secondary dropdown-toggle\" type=\"button\" id=\"dropdownMenuButton\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">Select product</button><div class=\"dropdown-menu\">" +
        productDropdownText+
        "</div></div>";
}
function openOrderRemoveModal(id) {
    orderIdToDelete = id;
    $('#orderRemoveModal').modal('show');
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

