function consultarCalificacion() {
    $.ajax({
        url: "http://158.101.14.132:8080/api/Score/all",
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
                  <th scope="col">Id Reserva</th>
                    <th scope="col">Calificacion</th>
                    <th scope="col">Mensaje</th>
                    <th>Acciones</th>
                </tr>`;


    for (var i = 0; i < items.length; i++) {
        tabla += `<tr>
                <td>${items[i].idReserva}</td>
                    <td>${items[i].score}</td>
                   <td>${items[i].message}</td>
                 <td>
                       <a href="detalleCalificacion.html?id=${items[i].id}" title="Editar" class="btn btn-light"><i class="bi bi-pencil"></i></a>
                   </td> 
                </tr>`;
    }
    tabla += `</table>`;

    $("#tabla").html(tabla);
}

