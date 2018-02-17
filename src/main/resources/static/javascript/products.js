var i = 0;
var products = [
    {
        id: 1223,
        name: 'nanan',
        categoryId: 213432,
        supplierId: 22,
        quantityPerUnit: 32,
        unitPrice: 23,
        unitsInStock: 23,
        unitsOnOrder: 32,
        reorderLevel: 324114324,
        discontinued: 0.3
    },
    {
        id: 12,
        name: 'aaa',
        supplierId: 22,
        categoryId: 213432,
        quantityPerUnit: 32,
        unitPrice: 23,
        unitsInStock: 23,
        unitsOnOrder: 32,
        reorderLevel: 324114324,
        discontinued: 0.5
    },
    {
        id: 13,
        name: 'nnn',
        categoryId: 213432,
        supplierId: 22,
        quantityPerUnit: 32,
        unitPrice: 23,
        unitsInStock: 23,
        unitsOnOrder: 32,
        reorderLevel: 324114324,
        discontinued: 0.9
    }
];

var productsMap = new Map();
for (i = 0; i < products.length; i++) {
    productsMap.set(products[i].id, products[i]);
}
var allProducts = [];
function getAllProducts () {
    var url = 'http://localhost:8080/products/readProducts';
    $.ajax({
        type: "POST",
        contentType : 'application/json; charset=UTF-8',
        url: url,
        success: function (res) {
            allProducts = res;
            console.log(res);
            //loadOrders(allOrders);
        },
        data: JSON.stringify({
        })
    });
}
//getAllProducts();

function openProductModal(productId) {

    var product = productsMap.get(productId);
    $('#id').val(product.id);
    $('#name').val(product.name);
    $('#categoryId').val(product.categoryId);
    $('#supplierId').val(product.supplierId);
    $('#quantityPerUnit').val(product.quantityPerUnit);
    $('#unitPrice').val(product.unitPrice);
    $('#unitsInStock').val(product.unitsInStock);
    $('#unitsOnOrder').val(product.unitsOnOrder);
    $('#reorderLevel').val(product.reorderLevel);
    $('#discontinued').val(product.discontinued);
    $('#productModal').modal('show');
}
function openProductCreateModal() {
    $('#productCreateModal').modal('show');
}
function openProductRemoveModal() {
    $('#productRemoveModal').modal('show');
}
function loadProductsToNewOrder(idTable) {
    var productTable = document.getElementById(idTable);
    var text = '';
    for (i = 0; i < products.length; i++) {
        text = text + "<tr><th>" + products[i].id + "</th><td>" + products[i].name + "</td><td>" + products[i].supplierId + "</td><td>" + products[i].categoryId + "</td><td>" + products[i].quantityPerUnit + "</td><td>" + products[i].unitPrice + "</td><td>" + products[i].unitsInStock + "</td><td>" + products[i].unitsOnOrder + "</td><td>" + products[i].reorderLevel + "</td><td>" + products[i].discontinued + "</td><td class='buttonTd'>      <input type=\"checkbox\" aria-label=\"Checkbox for following text input\">\n</td>";
    }
    productTable.innerHTML = text;
}
function loadProducts(idTable) {
    var productTable = document.getElementById(idTable);
    var text = '';
    for (i = 0; i < products.length; i++) {
        text = text + "<tr><th>" + products[i].id + "</th><td>" + products[i].name + "</td><td>" + products[i].supplierId + "</td><td>" + products[i].categoryId + "</td><td>" + products[i].quantityPerUnit + "</td><td>" + products[i].unitPrice + "</td><td>" + products[i].unitsInStock + "</td><td>" + products[i].unitsOnOrder + "</td><td>" + products[i].reorderLevel + "</td><td>" + products[i].discontinued + "</td><td class='buttonTd'><button type=\"button\" class=\"m_right_7 btn btn-primary btn-sm\" onclick=\"openProductModal(" + products[i].id + ")\">\n" +
            "            Edit</button><button type=\"button\" class=\"btn btn-danger btn-sm\" onclick=\"openProductRemoveModal()\">X</button></td>";
    }
    productTable.innerHTML = text;
}

loadProducts('productsTableBody');
