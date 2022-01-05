// Función para consultar mensaje
function consultarMensajes() {
    $.ajax({
        url: "http://158.101.14.132:8080/api/Message/all",
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
                  </tr>`;


    for (var i = 0; i < items.length; i++) {
        tabla += `<tr>
                   <td>${items[i].messageText}</td>
                   <td>${items[i].client.name}</td>
                   <td>${items[i].ortopedic.name}</td>
                 </tr>`;
    }
    tabla += `</table>`;

    $("#tabla").html(tabla);
}