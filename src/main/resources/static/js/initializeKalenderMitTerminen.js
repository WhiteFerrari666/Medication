var events = [
    {'Date': new Date(2020, 6, 10), 'Title': 'Arzttermin um 15:30', 'Link': 'https://www.docmuenster.de/'},
    {'Date': new Date(2020, 6, 26), 'Title': 'Aspirin nehmen', 'Link': 'https://www.aspirin.de/'},
    {
        'Date': new Date(2020, 6, 20),
        'Title': 'Pollensaison geht los',
        'Link': 'https://allergie.hexal.de/pollenflug/pollenflugkalender/'
    },
];
var settings = {};
var element = document.getElementById('kalender');
caleandar(element, events, settings);
