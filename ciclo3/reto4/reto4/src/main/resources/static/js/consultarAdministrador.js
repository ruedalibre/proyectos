function consultarAdministrador() {
    $.ajax({
        url: "http://158.101.14.132:8080/api/Admin/all",
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
                    <th scope="col">Nombre</th>
                    <th scope="col">Email</th>
                    <th scope="col">Password</th>
                    <th scope="col">Acciones</th>
                </tr>`;


    for (var i = 0; i < items.length; i++) {
        tabla += `<tr>
                   <td>${items[i].name}</td>
                   <td>${items[i].email}</td>
                   <td>${items[i].password}</td>
                   <td>
                   <a href="#" onclick="eliminarAdmin(${items[i].id})" title="Eliminar" class="btn btn-light"><i class="bi bi-trash"></i></a>
                   <a href="detalleAdmin.html?id=${items[i].id}" title="Editar" class="btn btn-light"><i class="bi bi-pencil"></i></a>
                   </td>
                   </tr>`;
    }

    tabla += `</table > `;

    $("#tabla").html(tabla);
}

