# ProgettoDART
LINK YT PER PLUGIN WindowBuilder -->  https://www.youtube.com/watch?v=4sVJuH0NdSw

GUIDA PER LA CONFIGURAZIONE GitHub/Eclipse
1.  Creare una nuova directory su Eclipse e aprirla
2.  NON CHIUDERE LA PAGINA DI WELCOME!! -> Cliccare su "Checkout projects from Git">"Clone URI"
(SE CHIUDETE LA PAGINA DI WELCOME --> andare su "Import projects">"Git">""Projects from Git" 
 cliccare next e scegliere "Clone URI" e continuare a seguire i passaggi)
3.  Inserire il seguente link all'interno del campo "URI"  -->    https://github.com/MartaLeonardi/ProgettoDART.git
4.  Gli altri due campi si compilano in automatico, immettere nella sezione di autenticazione le proprie credenziali GitHub(nome e password)
5.  Cliccare next due volte, SE la directory selezionata crea problemi poichè vuota, è possibile aggiungere una nuova cartella direttamente scrivendola nel campo stesso (ad esempio aggiungere \P)
6.  Cliccare next fino a che non spunta finish
7.  Attendere che la clonazione finisca


SE LA PASSWORD DI GITHUB DA PROBLEMI IN UN QUALUNQUE MOMENTO
1.  In alto a destra della pagina principale di GitHub online, cliccare l'icona dell'account e seguire il percorso qui sotto:
    "Setting">"Developer setting">"personal access tokens">"tokens (classic)>"generate new token"
2.  Nella configurazione del token selezionare la checkbox "repo" e scegliere come durata almeno 60 giorni e generate il token
3.  Per sicurezza copiate e salvate in un vostro documento il token generato, vi servirà al posto della vostra password di GitHub per più operazioni!

COMANDI GITHUB
*COMMIT E PUSH  --> Pone in ascolto GitHub e lo rende attivo al caricamento di file
1.  Dopo aver realizzato file all'interno di Eclipse, fare tasto destro e scegliere "Team">"Commit", si aprià in basso una schermata
2.  Spostare dalla sezione "Unstaged changes" alla sezione "Staged changes" i file che si intende caricare
3.  Completare con una breve descrizione nella sezione "Commit message" e cliccare "Commit and push"
(forzare l'operazione se necessario, e a volte c'è bisogno di ripetere l'operazione di Push quindi ricliccare il pulsante che è diventato "PUSH HEAD")

*PULL  -->  Aggiornare il contenuto della repository clonata con le modifiche dei collaboratori
1.  Cercare, attraverso la lente di ingrandimento in alto a destra, "Git repositories"
2.  Nella pagina di Eclipse si aprirà una finestra in basso a sinistra che mostra la repository a cui si ha accesso
3.  Tasto destro sulla repository e scegliere "Pull...", cliccare finish
4.  Apparirà una finestra col resoconto di ciò che stato aggiornato dall'ultima volta che si è fatto il Pull.

