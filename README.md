# Automata Finito en Java
Proyecto de teoría de la computación en el que se recibe información correspondiente a un autómata finito y con dicha información se genera un autómata. El proyecto permite al usuario de igual manera ingresar palabras y checar si dichas palabras resultan válidas para el autómata definido.

### Un poco de teoría ... 🦄

#### Autómata Finito
Es un modelo matemático de un sistema, con entradas y salidas discretas. El sistema puede estar en cualquiera de un número finito de configuraciones o “estados”.
Un autómata finito consiste en un conjunto finito de estados y un conjunto de transiciones de estado a estado, que se dan sobre símbolos de entrada tomadas de un alfabeto Σ.  

Un autómata finito o máquina de estado finito es una herramienta abstracta que se utiliza para reconocer un determinado lenguaje regular, es un modelo matemático de un sistema que recibe una cadena constituida por caracteres de cierto alfabeto y determina si esa cadena pertenece al lenguaje que el autómata reconoce.  

#### Funcionamiento
Un autómata finito se encuentra en un estado denominado Estado Inicial que tiene la característica de ser único, y uno o varios Estados finales que no siempre coinciden con el último estado del autómata. Si el estado inicial coincide con el final entonces el lenguaje reconocido será aquel que incluya a la palabra vacía.  

El funcionamiento de los autómatas finitos consiste en ir pasando de un estado a otro, a medida que va recibiendo los caracteres de la palabra de entrada. Este proceso puede ser seguido fácilmente en los diagramas de estados. Simplemente hay que pasar de estado a estado siguiendo las flechas de las transiciones, para cada carácter de la palabra de entrada, empezando por el estado inicial.

#### Definición formal  
Definición.- Una máquina de estados finitos M es un
quíntuplo (K, Σ, δ, s, F), donde:  
◦ K es un conjunto de identificadores (símbolos) de estados;  
◦ ∑ es el alfabeto de entrada;  
◦ s ϵ  K; es el estado inicial;  
◦ F contenido en K es un conjunto de estados finales;  
◦ δ : K × ∑ -> K es la función de transición, que a partir de un estado y un símbolo del alfabeto obtiene un nuevo estado.  

#### Ejemplo
![img1](https://github.com/UsagiHaku/Automata-Finito-Java/blob/master/AF.png)

El autómata finito de la figura está definido por el quíntuplo (K, Σ, δ, s, F),
donde:  
◦ K = {q0, q1, q2};  
◦ ∑ = {a,b};  
◦ s = q0 ;  
◦ F = {q1, q2};  
◦ δ = { ((q0, a), q1), ((q0, b), q2), ((q1, a), q1), ((q1, b), q1), ((q2, a), q0), ((q2, b), q2)}  
