# mediacenter-sync

A tool to sync the download list of a torrent server (utorrent) and a remote computer. 
The computer comunicate with an Rest API.

- /server - the core of the application made in Spring.
- /angularApp - the interface to interact with the user and the API.

## API petitions

### List files 
GET /api/files 
At the moment only can be filtered by : status=XXXXX

### Login
PUT /api/authSession/:password:

### List configuration
GET /api/configuration/
{
	"token" : "6982772"
}
