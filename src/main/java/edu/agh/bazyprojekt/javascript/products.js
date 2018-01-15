var products = [
    {
        id: 1223,
        name: 'nanan',
        categoryId: 213432,
        quantityPerUnit: 32,
        unitPrice:23,
        unitsInStock: 23,
        unitsOnOrder: 32,
        reorderLevel: 324114324,
        discontinued: 0.3
    },
    {
        id: 12,
        name: 'aaa',
        categoryId: 213432,
        quantityPerUnit: 32,
        unitPrice:23,
        unitsInStock: 23,
        unitsOnOrder: 32,
        reorderLevel: 324114324,
        discontinued: 0.3
    },
    {
        id: 13,
        name: 'nnn',
        categoryId: 213432,
        quantityPerUnit: 32,
        unitPrice:23,
        unitsInStock: 23,
        unitsOnOrder: 32,
        reorderLevel: 324114324,
        discontinued: 0.3
    }
];

function openProductModal(productId) {
    var productModal = document.getElementById('productModalBody');
    productModal.innerText = "<p>"+ productId +"</p>";
    $('#productModal').modal('show');
}

var productTable = document.getElementById('productsTableBody');
console.log(productTable);
var text = '';
for(var i=0;i<products.length;i++){
    text = text + "<tr><th>" + products[i].id +"</th><td>" + products[i].name + "</td><td>" +products[i].categoryId +"</td><td>" +products[i].quantityPerUnit +"</td><td>"+products[i].quantityPerUnit+"</td><td>"+products[i].quantityPerUnit+"</td><td>"+products[i].quantityPerUnit+"</td><td>"+products[i].quantityPerUnit+"</td><td>"+products[i].quantityPerUnit+"</td><td>"+products[i].discontinued+"</td><td><button type=\"button\" class=\"btn btn-primary btn-sm\" onclick=\"openProductModal("+products[i].id +")\">\n" +
        "            Edit\n" +
        "        </button></td>";
}
productTable.innerHTML = text;