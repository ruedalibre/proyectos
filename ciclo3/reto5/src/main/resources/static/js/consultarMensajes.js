function consultarMensajes() {
    $.ajax({
        url: "http://158.101.14.132:8080/api/Message/all",
        //url: "http://localhost:8080/api/Message/all",
        type: 'GET',
        dataType: 'json',
        success: function (respuesta) {
            console.log(respuesta);
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
                    <th>Mensaje</th>
                    <th>Cliente</th>
                    <th>Ortesis</th>
                    <th>Acciones</th>
                  </tr>`;


    for (var i = 0; i < items.length; i++) {
        tabla += `<tr>
                <td>${items[i].messageText}</td>
                <td>${items[i].client.name}</td>
                <td>${items[i].ortopedic.name}</td>
                <td>
                    <a href="#" onclick="eliminarMensaje(${items[i].idMessage})" title="Eliminar" class="btn btn-light"><i class="bi bi-trash"></i></a>
                    <a href="detalleMensaje.html?id=${items[i].idMessage}" title="Editar" class="btn btn-light"><i class="bi bi-pencil"></i></a>
                </td>       
                </tr>`;
    }
    tabla += `</table>`;

    $("#tabla").html(tabla);
}