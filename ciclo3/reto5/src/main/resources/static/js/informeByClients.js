var InformeByClients = function(){
    
    $.ajax({
        url: "http://158.101.14.132:8080/api/Reservation/report-clients/",
        //url: "http://localhost:8080/api/Reservation/report-clients/",
        type: 'GET',
        dataType: 'json',
        success: function (respuesta) {
            console.log(respuesta);
            mostrarRespuestaxCliente(respuesta);
        },
        error: function (xhr, status) {
            console.log(xhr);
            console.log(status);
            alert('ha sucedido un problema');
        }
    });
};

var mostrarRespuestaxCliente = function (items) {
    var tabla = `<table border="1" class="table table-striped table-hover">
                  <tr>
                    <th>Número de reservas</th>
                    <th>Cliente</th>
                  </tr>`;


    for (var i = 0; i < items.length; i++) {
           tabla += `<tr>
              <td>${items[i].total}</td>
            <td>${items[i].client.name}</td>
            
            </tr>`;
    }
    tabla += `</table>`;

    $("#tablainfCli").html(tabla);
};
