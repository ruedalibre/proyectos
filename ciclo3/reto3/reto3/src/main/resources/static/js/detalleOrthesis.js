// Función para mostrar detalles de orthesis 
$(document).ready(function () {
    console.log("document ready!");
    let searchParams = new URLSearchParams(window.location.search);
    if (searchParams.has('id')) {
        let id = searchParams.get('id');
        consultarById(id);
    }
});

function consultarById(id) {
    $.ajax({
        url: "http://158.101.14.132:8080/admin/orthesis/orthesis/" + id,
        type: 'GET',
        dataType: 'json',
        success: function (respuesta) {
            console.log(respuesta.items);
            if (respuesta.items.length === 1) {
                llenarDatos(respuesta.items[0]);
            } else {
                $("#boton").hide();
                alert('No se encuentra el gato con el id ' + id);
            }
        },
        error: function (xhr, status) {
            alert('ha sucedido un problema');
        }
    });
}

function llenarDatos(item) {
    $("#id").val(item.id);
    $("#brand").val(item.brand);
    $("#model").val(item.model);
    $("#category_id").val(item.category_id);
    $("#name").val(item.name);
}