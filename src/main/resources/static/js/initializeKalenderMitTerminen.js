var requestURL = 'http://localhost:8080/kalender';
var request = new XMLHttpRequest();
request.open('GET', requestURL);
request.responseType = 'json';
request.send();
var termine = JSON.parse(request.response)
var events = termine;


/*[
    // in diesem Format sollen die geparsten Daten vorliegen, damit der Kalender sie unten verarbeiten/aufnehmen kann
    // wie kriege ich die aus dem JSON in diese Variable bzw. dieses Format?

   //termine

    {"Date": new Date(2020, 7, 10), "Title": "Arzttermin um 15:30", "Link": "https://www.docmuenster.de/"},
    {"Date": new Date(2020, 5, 26), 'Title': 'Aspirin nehmen', 'Link': 'https://www.aspirin.de/'},
    {
        'Date': new Date(2020, 4, 19),
        'Title': 'Pollensaison geht los',
        'Link': 'https://allergie.hexal.de/pollenflug/pollenflugkalender/'
    }
];*/
var settings = {};
var element = document.getElementById('kalender');
caleandar(element, events, settings);
