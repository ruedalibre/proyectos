function consultarCliente() {
    $.ajax({
        url: "http://158.101.14.132:8080/api/Client/all",
        type: 'GET',
        dataType: 'json',
        success: function (respuesta) {
            mostrarRespuesta(respuesta);
        },
        error: function (xhr, status) {
            alert('Ha sucedido un problema');
        }
    });

}

function mostrarRespuesta(items) {
    var tabla = `<table border="1" class="table table-striped table-hover">
                <tr>
                <th>Nombre</th>
                <th>Correo electrónico</th>
                <th>Edad</th>
                <th scope="col">Mensajes</th>
            <th scope="col">Reservaciones</th>
                </tr>`;


    for (var i = 0; i < items.length; i++) {
        tabla += `<tr>
                    <td>${items[i].name}</td>
                    <td>${items[i].email}</td>
                    <td>${items[i].age}</td>
                    <td>${items[i].messages.length}</td>
                    <td>${items[i].reservations.length}</td>`;
    }

    tabla += `</tr></table>`;

    $("#tabla").html(tabla);
}