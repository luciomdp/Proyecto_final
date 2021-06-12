# Proyecto_final
La Liga Continental de Fútbol requiere un software para gestionar su Campeonato Anual. La Liga
nos brinda la siguiente información sobre el reglamento de dicha competencia:
 Participan 16 equipos divididos en 4 zonas de 4 equipos. En cada zona, cada equipo se enfrenta
con los 3 restantes en una sola ocasión, no hay ida y vuelta. En cada partido de la zona, el
ganador obtiene 3 puntos, el perdedor 0, y en caso de empate ambos equipos obtienen 1 punto.
 En la tabla de posiciones de cada zona, en el caso de empate en puntos la posición se define por
mejor diferencia de gol, y en caso de empate por este criterio, por cantidad de goles a favor. Si
persiste la igualdad se tiene en cuenta el resultado entre ambos equipos empatados.
 Los 2 primeros equipos de cada zona pasan a la siguiente instancia de eliminación directa
(cuartos de final). Los ganadores de los cuartos de final pasan a la instancia de semifinal y los
ganadores de esta instancia a la final del campeonato. Los cuartos de final y semifinales son
partidos de ida y vuelta, o sea 2 partidos por cada instancia. La final es un partido único.
 El ganador de los partidos de ida y vuelta es el equipo que haya obtenido mayor puntaje contando
ambos partidos. En caso de empate en puntos, se resuelve por mejor diferencia de gol, teniendo en
cuenta que los goles de visitante valen doble. Si se mantiene la igualdad, el ganador se define por
la ejecución de tiros penales.
 Si la final finaliza en empate en los 90 minutos, también se define con tiros penales.
 Para cada equipo se registra: nombre, país, posición en ranking continental, su plantel de 18
jugadores (2 arqueros, 6 defensores, 5 mediocampistas, 5 delanteros) y su DT.
 Para cada persona que participa del torneo (jugador, DT, referí) se registra su apellido y nombre,
fecha de nacimiento, tipo y número de documento.
 Para los jugadores se registra su posición (arquero, defensor, mediocampista, delantero) y puntaje
de valoración (a modo de los juegos de consola o cartas)
 Para los DT registrar nacionalidad y cantidad de títulos obtenidos en todos los niveles (nacional o
internacional).
 Para los referís se registra nacionalidad y cantidad de años en el referato.
 Para cada partido se registra: fecha, los dos equipos que se enfrentan y el referí. El referí no podrá
tener la misma nacionalidad que cualquiera de los equipos, a no ser que se enfrenten dos equipos
de la misma nacionalidad.
o Luego de cargarse la información se emitirán las identificaciones de todas las personas
participantes del partido, con sus datos personales y su rol en el evento.
o El resultado del partido surge de una simulación que tenga en cuenta las posiciones en el
ranking de ambos equipos, el promedio de las valoraciones de los jugadores, y los títulos
conseguidos por los DT. Además de estos datos, deberá existir un componente aleatorio
(random) que defina el resultado.
o Para los partidos de la fase inicial (zonas) se deberá mostrar el estado de la tabla de
posiciones antes y después de registrado el resultado. Para cada equipo, mostrar: puntos,
partidos jugados, ganados, empatados y perdidos, goles a favor y en contra, diferencia de
gol.
o En los partidos de la fase final (de cuartos de final hasta la final) la simulación se realizará
en 2 pasos: en primer lugar, el resultado de los 90 minutos, y luego, de corresponder, el de 
UNIVERSIDAD FASTA
PROGRAMACIÓN B
PÁGINA 2/4 – TRABAJO PRÁCTICO GRUPAL
la ejecución de tiros penales. En todos los casos, indicar el criterio que haya determinado al
ganador.
 En cualquier momento se podrá emitir los siguientes reportes:
o Listado alfabético de los equipos mostrando edad promedio de sus jugadores, edad y
nacionalidad de su DT, efectividad (porcentaje de puntos obtenidos sobre puntos posibles).
o Ranking de referís por cantidad de partidos dirigidos en el campeonato. Indicar para cada
uno la cantidad de años en el referato, y al final del listado el promedio de los mismos.
o Listado de jugadores de determinada posición seleccionada por el operador (arquero,
defensor, mediocampista, delantero) mostrando toda la información disponible del mismo.
En el caso de los arqueros, mostrar la cantidad de Goles en Contra que recibió su equipo y
el promedio de gol recibido por partido.
