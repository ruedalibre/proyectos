function actualizarOrthesis() {
    console.log("ejecutando actualizar");

    let orthesis = {
        id: +$("#id").val(),
        brand: $("#brand").val(),
        year: +$("#model").val(),
        category_id: +$("#category_id").val(),
        name: $("#name").val(),
        description: $("#description").val()
    };

    console.log(orthesis);

    $.ajax({
        url: "http://158.101.14.132:8080/api/Ortopedic/update",
        //url: "http://localhost:8080/api/Ortopedic/update",
        type: 'PUT',
        dataType: 'json',
        headers: {
            "Content-Type": "application/json"
        },
        data: JSON.stringify(orthesis),
        statusCode: {
            201: function () {
                alert('Se ha actualizado la orthesis');
            }
        }
    });


}