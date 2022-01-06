var InformeByStatus = function () {


    $.ajax({
        url: "http://158.101.14.132:8080/api/Reservation/report-status",
        //url: "http://localhost:8080/api/Reservation/report-status",
        type: 'GET',
        dataType: 'json',
        success: function (respuesta) {
            console.log(respuesta);
            mostrarRespuestaxStatus(respuesta);
        },
        error: function (xhr, status) {
            console.log(xhr);
            console.log(status);
            alert('ha sucedido un problema');
        }
    });
};

var mostrarRespuestaxStatus = function (items) {
    var tabla = `<table border="1" class="table table-striped table-hover">
                  <tr>
                    <th>Reservas completadas</th>
                    <th>Reservas canceladas</th>
                  </tr>`;



    tabla += `<tr>
            <td>${items.completed}</td>
            <td>${items.cancelled}</td>
            </tr>`;


    tabla += `</table>`;

    $("#tablainfSta").html(tabla);
};
