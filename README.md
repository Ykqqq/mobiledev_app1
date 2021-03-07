# mobiledev_app1


THE APP
To login you must enter your client ID (here from 1 to 15)

If it is the first time you connect, the application will automatically download your informations to the local SQLite database.
If you already used the app, you will connect directly to your local informations (offline) and have the possibility to synchronize the online informations.

After connexion you can disconnect.
On the login page you can delete your local informations to connect to another account, just press the delete button then enter the other id and login.


SECURE 

The informations are stored in a SQLite3 database which is a secure database with some restrictions of access.
Your ID is stored hashed (sha-512) to protect from being retrieved.
To go further we could also add some "salt" in the ID before the hash, and encrypt the rest of the informations (amount, iban, currency)

SCREENSHOTS

First, we have the login page, with the id field, the login button and the delete button to delete the local database and connect to another account.

![Alt text](Login.jpg?raw=true "Optional Title")

Then we have the information page which shows the informations of your account.
In my case, I did not succeed to retrieve the online informations.

![Alt text](ViewInformations.jpg?raw=true "Optional Title")
