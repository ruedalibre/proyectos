// Fórmulas del cuadrado

/* En esta VARIACIÓN DEL EJERCICIO no se usarán valores fijos
 sino que los valores entrarán a una función que puede recibir
 los valores que yo quiera*/ 

 console.group("Cuadrados");
// const ladoCuadrado = 17;
// console.log("Los lados del cuadrado miden: " + ladoCuadrado + "cm");

function perimetroCuadrado(lado) {
    return lado * 4;
} 
// console.log("El perímetro del cuadrado es: "  + perimetroCuadrado + "cm"); 

// const areaCuadrado = lado **2;

function areaCuadrado(lado) {
    return lado**2;
}
// console.log("El área del cuadrado es: "  + areaCuadrado + "cm2"); 

console.groupEnd();

// Fórmulas del triángulo

console.group("Triángulos");
// const ladoTriangulo1 = 6;
// const ladoTriangulo2 = 6;
// const baseTriangulo = 4;
// console.log("Los lados del tríangulo miden: " + ladoTriangulo1 
//     + "cm,", ladoTriangulo2 
//     + "cm y " + baseTriangulo + "cm.");
// const perimetroTriangulo = ladoTriangulo1 + ladoTriangulo2 + baseTriangulo;
// const semiPerTriangulo = perimetroTriangulo / 2;
 
// function perimetroTriangulo (valueL1, valueL2, valueBase) {
//     return valueL1 + valueL2 + valueBase;
// }

// function semiPerimetro (perimetroTriangulo) {
//     return perimetroTriangulo / 2;
// }

// console.log("El perímetro del triángulo mide " 
//     + perimetroTriangulo + "cm y el semi perímetro mide " + semiPerTriangulo + "cm")

// Para hallar el área del tríangulo usaré le Fórmula de Herón: 

// const areaTriangulo = Math.sqrt(semiPerTriangulo 
//     * (semiPerTriangulo - ladoTriangulo1) 
//     * (semiPerTriangulo - ladoTriangulo2) 
//     * (semiPerTriangulo - baseTriangulo))
// console.log("El área del tríangulo es: " + areaTriangulo + "cm2");

// function areaTriangulo (semiPerimetro, lado1, lado2, base) {
//     return Math.sqrt(semiPerimetro 
//             * (semiPerimetro - lado1) 
//             * (semiPerimetro - lado2) 
//             * (semiPerimetro - base));
// }

// const alturaTriangulo = (2 * areaTriangulo) / baseTriangulo;
// console.log("Y la altura del triángulo es: " + alturaTriangulo + "cm")
// function alturaTriangulo (areaTriangulo, base) {
//     return (areaTriangulo * 2) / base;
// }
console.groupEnd();

// Fórmulas del círculo

console.group("Círculos");
// const radio = 4;
// console.log("El radio del círculo es: " + radio + "cm");

function diametroCirculo (radio) {
    return radio * 2;
}

// const diametro = radio * 2;
// console.log("El diámetros del círculo es: " + diametro + "cm");

const pi = Math.PI;
console.log("El varlor de PI es: " + pi);

// const circunferencia = diametro * pi; 
// console.log("La circunferencia del círculo es: " +  circunferencia + "cm");
function circunferencia (diametro) {
    return diametro * pi;
}

// const areaCirculo = pi * (radio **2);
// console.log("El área del círculo es: " + areaCirculo + "cm2"); 
function areaCirculo (radio) {
    return pi * (radio ** 2);
}

console.groupEnd();

// AQUÍ EMPIEZA LA PROGRAMACIÓN DE LOS FORMULARIOS HTML. 

function calcPerimetroCuadrado() {
    const input = document.getElementById("inputCuadrado");
    // De esta manera accedo al input creado en el html 
    const value = input.value;
    /* Pero como solo necesito el valor, entonces guardo el 
     resultado en una variable para poder utilizarlo */
    const perimetro = perimetroCuadrado(value);
    // alert(perimetro);
    alert(perimetro);
}

function calcAreaCuadrado() {
    const input = document.getElementById("inputCuadrado");
    const value = input.value;
    const area = areaCuadrado(value);
    alert(area);
}

function calcPerimetroTriangulo() {
    const inputL1 = document.getElementById("inputTriangulo1");
    const valueL1 = inputL1.value;

    const inputL2 = document.getElementById("inputTriangulo2");
    const valueL2 = inputL2.value;

    const inputBase = document.getElementById("inputTriangulo3");
    const valueBase = inputBase.value;

    const lado1 = Number(valueL1);
    const lado2 = Number(valueL2);
    const base = Number(valueBase);

    const perimetro = lado1 + lado2 + base;
    
    alert(perimetro);
    };


function calcAreaTriangulo() {
    const inputL1 = document.getElementById("inputTriangulo1");
    const valueL1 = inputL1.value;

    const inputL2 = document.getElementById("inputTriangulo2");
    const valueL2 = inputL2.value;

    const inputBase = document.getElementById("inputTriangulo3");
    const valueBase = inputBase.value;

    const lado1 = Number(valueL1);
    const lado2 = Number(valueL2);
    const baseT = Number(valueBase);

    const perimetro = lado1 + lado2 + baseT;

    const semiPerimetro = perimetro / 2;

    const areaTrian = Math.sqrt(semiPerimetro 
                * (semiPerimetro - lado1) 
                * (semiPerimetro - lado2) 
                * (semiPerimetro - baseT));
    
    alert(areaTrian); 

}

function calcAlturaTriangulo() {
    const inputL1 = document.getElementById("inputTriangulo1");
    const valueL1 = inputL1.value;

    const inputL2 = document.getElementById("inputTriangulo2");
    const valueL2 = inputL2.value;
    
    const inputBase = document.getElementById("inputTriangulo3");
    const valueBase = inputBase.value;

    const lado1 = Number(valueL1);
    const lado2 = Number(valueL2);
    const baseT = Number(valueBase);

    const perimetro = lado1 + lado2 + baseT;

    const semiPerimetro = perimetro / 2;

    const areaTrian = Math.sqrt(semiPerimetro 
                * (semiPerimetro - lado1) 
                * (semiPerimetro - lado2) 
                * (semiPerimetro - baseT));

    const alturaTrian = (areaTrian * 2) / baseT;

    alert(alturaTrian);
}


function calcCircunferencia() {
    const input = document.getElementById("inputCirculo");
    const value = input.value;

    const perimetro = circunferencia(value);
    alert(perimetro);

}

function calcAreaCirculo() {
    const input = document.getElementById("inputCirculo");
    const value = input.value;

    const area = areaCirculo(value);
    alert(area);

}

