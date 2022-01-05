var InformeByFechas = function () {
    let fi = $("#startDateInf").val();
    let ff = $("#devolutionDateInf").val();
    console.log(fi);
    console.log(ff);

    $.ajax({
        url: "http://158.101.14.132:8080/api/Reservation/report-dates/" + fi + "/" + ff,
        //url: "http://localhost:8080/api/Reservation/report-dates/" + fi + "/" + ff,
        type: 'GET',
        dataType: 'json',
        success: function (respuesta) {
            console.log(respuesta);
            mostrarRespuestaxFecha(respuesta);
        },
        error: function (xhr, status) {
            console.log(xhr);
            console.log(status);
            alert('ha sucedido un problema');
        }
    });
};

var mostrarRespuestaxFecha = function (items) {
    var tabla = `<table border="1" class="table table-striped table-hover">
                  <tr>
                    <th>Fecha de inicio</th>
                    <th>Fecha de devolución</th>
                    <th>Cliente</th>
                    <th>Ortesis</th>
                    <th>Estatus</th>
                  
                  </tr>`;


    for (var i = 0; i < items.length; i++) {
        tabla += `<tr>
            <td>${items[i].startDate.substring(0, 10)}</td>
            <td>${items[i].devolutionDate.substring(0, 10)}</td>
            <td>${items[i].client.name}</td>
            <td>${items[i].ortopedic.name}</td>
            <td>${items[i].status}</td>
            
            </tr>`;
    }
    tabla += `</table>`;

    $("#tablainfRes").html(tabla);
};
