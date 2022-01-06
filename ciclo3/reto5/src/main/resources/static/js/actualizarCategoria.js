function actualizarCategoria() {
    console.log("ejecutando actualizar");

    let categoria = {
        id: $("#id").val(),
        name: $("#name").val(),
        description: $("#description").val()
    };

    console.log(categoria);

    $.ajax({
        url: "http://158.101.14.132:8080/api/Category/update",
        //url: "http://localhost:8080/api/Category/update",
        type: 'PUT',
        dataType: 'json',
        headers: {
            "Content-Type": "application/json"
        },
        data: JSON.stringify(categoria),
        statusCode: {
            201: function () {
                alert('Se ha actualizado los datos de la categoria');
            }
        }
    });


}