// Función para mostrar detalles de mensaje
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
        url: "http://158.101.14.132:8080/admin/message/message/" + id,
        type: 'GET',
        dataType: 'json',
        success: function (respuesta) {
            console.log(respuesta.items);
            if (respuesta.items.length === 1) {
                llenarDatos(respuesta.items[0]);
            } else {
                $("#boton").hide();
                alert('No se encuentra el mensaje con el id ' + id);
            }
        },
        error: function (xhr, status) {
            alert('Ha ocurrido un problema');
        }
    });
}

function llenarDatos(item) {
    $("#id").val(item.id);
    $("#messagetext").val(item.messagetext);
}