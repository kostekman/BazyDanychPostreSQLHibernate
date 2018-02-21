var i = 0;
function openProductDetailModal(productId) {
    var product = productsMap.get(productId);
    console.log(product);

    document.getElementById('id').innerHTML = product.productId;
    document.getElementById('name').innerHTML = product.productName;
    document.getElementById('quantityPerUnit').innerHTML = product.quantityPerUnit;
    document.getElementById('unitPrice').innerHTML = product.unitPrice;
    document.getElementById('unitsInStock').innerHTML = product.unitsInStock;
    document.getElementById('unitsOnOrder').innerHTML = product.unitsOnOrder;
    document.getElementById('reorderLevel').innerHTML = product.reorderLevel;
    document.getElementById('discontinued').innerHTML = product.discontinued;

    var tabletext = '';
    for(i=0;i<product.orderDetails.length;i++){
        tabletext = tabletext + '<tr><td>'+product.orderDetails[i].orderId +'</td><td>'+ product.orderDetails[i].quantity+'</td><td>'+product.orderDetails[i].discount+'</td></tr>'
    }
    document.getElementById('detailsProductTableBody').innerHTML = tabletext;

    $('#productDetailsModal').modal('show');
}
function openProductCreateModal() {
    $('#productCreateModal').modal('show');
}
function openProductRemoveModal(id) {
    productToDelete = id;
    $('#productRemoveModal').modal('show');
}
function filterProductFun(type) {
    var filterValue = document.getElementById('productInputSearch').value;
    if(filterValue === ''){
        getAllProducts();
    }else{
        switch(type){
            case 1:
                getProductsById(filterValue);
                break;
            case 2:
                getProductsByName(filterValue);
                break;
            default:
                break;
        }

    }
}
getAllProducts();
