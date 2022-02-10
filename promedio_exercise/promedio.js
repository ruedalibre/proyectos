/* -----------------------------------------
SOLUCIÓN CON VALORES QUEMADOS Y CICLO FOR
--------------------------------------------*/
/* const lista1 = [
    100,
    200,
    300,
    500
];
*/ 

// Inicia la variable en cero
// let sumaLista1 = 0;

/* Creo la variable i que va a iterar en la lista.
Va a iterar de acuerdo a la cantidad de elementos 
que tenga la lista (lenght) */

// for (let i = 0; i < lista1.length; i++) {
    /* Arranca en cero y con cada iteración va guardando
    la suma acumulada en la variable */
    // sumaLista1 = sumaLista1 + lista1[i];
// } 
// const promedioLista1 = sumaLista1 / lista1.length

/* ------------------------------
SOLUCION CON CICLO FOR

El mismo ejercicio pero utilizando una función 
para que el usuario ingrese los valores deseados, 
los cuales quedarán almacendos en forma de lista, 
para luego calcular el promedio

function calcularMediaAritmetica(lista) {

    // Inicia la variable en cero
    let sumaLista = 0;
    
    for (let i = 0; i < lista.length; i++) {
        sumaLista = sumaLista + lista[i];
    }
    const promedioLista = sumaLista / lista.length;

    return promedioLista;
}
--------------------------------*/

/* -----------------------------------------
    SOLUCIÓN CON ITERACION USANDO LOS 
    MÉTODOS PROPIOS DE ARRAY
--------------------------------------------*/
function calcularMediaAritmetica(lista) {
    
    /* Método reduce recibe los valores 
    de la lista y automáticamente les aplica 
    una operación (suma, resta, multiplicación, etc */
    const sumaLista = lista.reduce(
        /* valorAcumulado será el valor por 
        defecto inicialy nuevoValor es el 
        valor que ingresa y se suma al anterior.
        En la segunda iteración esta suma 
        asumirá el valor de valorAcumulado */ 
        function (valorAcumulado = 0, nuevoValor) {
            return valorAcumulado + nuevoValor;

        }
    );
    const promedioLista = sumaLista / lista.length;
    return promedioLista;
}




