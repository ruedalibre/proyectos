function calcularMediaAritmetica(lista) {
    const sumaLista = lista.reduce(
        function (valorAcumulado = 0, nuevoValor) {
            return valorAcumulado + nuevoValor;
        }
    );
    const promedioLista = sumaLista / lista.length;
    return promedioLista;
}

/* -------------------------------------
        USANDO UNA FUNCIÓN
 --------------------------------------*/

/* Primero uso el método .sort para organizar 
 en orden ascendente los números ingresados 
 por el usuario*/
 function ordenarNumeros(lista) {
    var numerosOrdenados = lista.sort(function(a,b) {
        return a - b; 
    });
    console.log(numerosOrdenados);
 }
    
function esPar(numeros) {
    if (numeros % 2 === 0) {
        return true;
    } else {
        return false;
    };
}

function calcualarMediana(listaNumeros) {
    const listaEnOrden = ordenarNumeros(listaNumeros);
    
    const mitadLista1 = parseInt(listaEnOrden.length / 2);
    
    let mediana; 
        if (esPar(listaEnOrden.length)) {
            const elemento1 = listaEnOrden[mitadLista1 -1];
            const elemento2 = listaEnOrden[mitadLista1];
            const promedioElemento1y2 = calcularMediaAritmetica([elemento1, elemento2]);

            mediana = promedioElemento1y2;
        } else {
            mediana = listaEnOrden[mitadLista1];
        }
        return mediana;
}
