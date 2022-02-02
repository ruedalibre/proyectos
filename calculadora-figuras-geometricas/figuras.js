// Fórmulas del cuadrado

console.group("Cuadrados");
const ladoCuadrado = 17;
console.log("Los lados del cuadrado miden: " + ladoCuadrado + "cm");

const perimetroCuadrado = ladoCuadrado * 4;
console.log("El perímetro del cuadrado es: "  + perimetroCuadrado + "cm"); 

const areaCuadrado = ladoCuadrado **2;
console.log("El área del cuadrado es: "  + areaCuadrado + "cm2"); 

console.groupEnd();

// Fórmulas del triángulo

console.group("Triángulos");
const ladoTriangulo1 = 6;
const ladoTriangulo2 = 6;
const baseTriangulo = 4;
console.log("Los lados del tríangulo miden: " + ladoTriangulo1 
    + "cm,", ladoTriangulo2 
    + "cm y " + baseTriangulo + "cm.");
const perimetroTriangulo = ladoTriangulo1 + ladoTriangulo2 + baseTriangulo;
const semiPerTriangulo = perimetroTriangulo / 2;
console.log("El perímetro del triángulo mide " 
    + perimetroTriangulo + "cm y el semi perímetro mide " + semiPerTriangulo + "cm")

// Para hallar el área del tríangulo usaré le Fórmula de Herón: 

const areaTriangulo = Math.sqrt(semiPerTriangulo 
    * (semiPerTriangulo - ladoTriangulo1) 
    * (semiPerTriangulo - ladoTriangulo2) 
    * (semiPerTriangulo - baseTriangulo))
console.log("El área del tríangulo es: " + areaTriangulo + "cm2");

const alturaTriangulo = (2 * areaTriangulo) / baseTriangulo;
console.log("Y la altura del triángulo es: " + alturaTriangulo + "cm")
console.groupEnd();

// Fórmulas del círculo

console.group("Círculos");
const radio = 4;
console.log("El radio del círculo es: " + radio + "cm");

const diametro = radio * 2;
console.log("El diámetros del círculo es: " + diametro + "cm");

const pi = Math.PI;
console.log("El varlor de PI es: " + pi);

const circunferencia = diametro * pi; 
console.log("La circunferencia del círculo es: " +  circunferencia + "cm");

const areaCirculo = pi * (radio **2);
console.log("El área del círculo es: " + areaCirculo + "cm2"); 

console.groupEnd();
