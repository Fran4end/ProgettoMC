#Progetto Mosca Ceca

##Scacchiera di gioco

- Il gioco si svolge su una scacchiera di n righe e n colonne che rappresenta il mondo all’interno del quale gli agenti si muovono.
- Ogni casella della scacchiera può essere:
    - libera,
    - occupata da un agente,
    - occupata da una risorsa.

##Scopo del gioco

Lo scopo del gioco è conquistare quanto più territorio possibile entro un certo tempo (o un certo numero di mosse) stabilito all’inizio della partita.

##Comportamento agenti

Ad ogni turno un agente può eseguire una sola delle seguenti operazioni.
- Spostarsi di una casella (destra, sinistra, su, giù e diagonale) se questa non è occupata da un altro agente.
- Piantare un fazzoletto se si trova su una casella libera.
- Consumare una unità di risorsa se si trova su una casella occupata da una risorsa.
- Ogni agente ha un livello di energia da 0 a 100 che deve mantenere sopra a 0 altrimenti cessa di esistere.
- Ogni movimento sulla scacchiera ed ogni fazzoletto piantato consumano un’unità di energia.
- Alcune caselle contengono “Colonne di ricarica”, un agente che si trova in una di esse aumenta di 10 unità la sua energia ad ogni turno (fino a  raggiungere un massimo di 100).
- Un agente può attaccare un altro agente che si trovi su un proprio territorio. Se l’attacco va a buon fine, la vittima perde 5 unità di stoffa (perde tutte le unità, se ne possiede meno di 5). L’attaccante consuma 2 unità di energia per ogni attacco. L’esito dell’attacco a casuale (50-50).

##Informazione degli agenti
Ogni agente in ogni momento conosce:
- dove si trova e quanto dista la colonnina di ricarica più vicina;
- lo stato delle caselle adiacenti;
- Tutte le caselle (posizione e numero) che hanno un suo fazzoletto.

##Utilizzo delle risorse
Sono presenti due tipi di risorse:
- Energia, presente nelle colonnine di ricarica. Le colonne di ricarica hanno una quantità infinita di energia, ma ne trasferiscono 10 unità ad ogni turno.
- Stoffa, presente in alcuni punti della mappa. La quantità di stoffa presente in un punto è limitata ed ogni volta che un agente ne raccoglie un’unità, la risorsa corrispondente diminuisce di un’unità.
<details><summary>Get details</summary>
Per poter piantare un fazzoletto è necessario avere 4 unità di stoffa, se c’è un’altra bandiera in una casella adiacente, altrimenti ne servono 8 unità. Una volta piantato un fazzoletto, le unità di stoffa dell’agente diminuiscono di un numero di unità corrispondente a quello necessario per posizionare la bandiera.
</details>

Le risorse, che sono generate in modo casuale all’inizio della partita, possono essere utilizzate secondo le seguenti regole
- Un solo agente per volta può usare la risorsa (se disponibile)
