# PROGETTO E-COMMERSE CORSO JAVA EE

---

## Entità

- Utente :
    entità principale raccoglie i dati dell utente quali nome, cognome  e numero di telefono (memorizzato come oggetto appartenente ad una lista);
    Ha una lista di indirizzi associati attraverso una lista 
    ha un RUOLO -> di base è impostato a AMMINISTRATORE.
    può essere cambiato in qualsiasi momento ma attenzione SOLO UN AMMINISTRATORE PUO MODIFICARE RUOLI DI ALTRI UTENTI.
    Ha associato una lista di ordini
    Ha anche un ID come anticipazione per la mappatura su DB.
> Metodi 
    metodi piu importanti sono Info (restituisce tutte le informazioni)
    CreaOrdine : come suggerisce il nome permette di creare da zero un ordine che verrà poi associato alla lista
    CreaRigaOrdine: serve per la creazione di una riga di ordine (ovvero le specifiche articolo per articolo)


- IndirizzoUtente :
    racchiude le info di uo o piu indirizzi dell'utente puo essere di due tipi, fatturazione o spedizione


- Ordine : L'oggetto che rappresenta il foglio di ordine SENZA le righe dell'ordine, sono infatti associte ramite una lista 
durante la creazione dell'ordine da parte dell'utente il costruttore andrà a leggere gli indirizzi dell'utente e a settare come spedizione o fatturazione i relativi, nel caso non li trovasse viene lanciato dalla console un messaggio che impone di settarli (un ordine senza indirizzi se proviamo a settare altri parametri verrà cancellato)
andrà anche a richiedere un metodo di pagamento e nel caso non combaciasse con quelli di base andrà ad aggiungerlo e settarlo come tipologia preferita.
Ha come attributo anche una lista di righe ordine in quanto un ordine puo avere molte specifiche su articoli e permette si ala creazione di righe sia l'aggiunta alla lista e le varie info (anche se si preferisce farlo attraverso l'oggetto utente)

- Riga Ordine racchiude le informazioni relative a quale articolo l'utente vuole acquistare e in quale quantità andrà poi associato ad un ordine e di conseguenza ad un utente.

- Articolo: rapprsenta un articolo nel magazzino uno dei campi chiave è CATEGORIA_PRODOTTO
è un enumerato che ha al suo interno degli oggetti che hanno come attributo un nome e una reference alla categoria padre/madre
in modo da creare delle sottocategorie attraverso le quali fosse possibile risalire alla categoria precendente. È necessario settare le categorie manualmente durante la creazione di un articolo, la categoria base è PRODOTTO.





## FUNZIONALIT­à

creazione articoli 
creazione utente e setaggio di tutti gli attriuti
creazione di un ordine 

creazione di una riga di ordine 
possibilità di avere le info relative ad ogni ordine/rigaordine 

metodi paga/spedisci che cambiano lo stato dell'ordine simulando la spedizione 


