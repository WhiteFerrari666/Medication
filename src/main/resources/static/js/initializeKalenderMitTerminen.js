var events = [
    {'Date': new Date(2020, 5, 10), 'Title': 'Arzttermin um 15:30', 'Link': 'https://www.docmuenster.de/'},
    {'Date': new Date(2020, 5, 26), 'Title': 'Aspirin nehmen', 'Link': 'https://www.aspirin.de/'},
    {
        'Date': new Date(2020, 4, 19),
        'Title': 'Pollensaison geht los',
        'Link': 'https://allergie.hexal.de/pollenflug/pollenflugkalender/'
    },
];
var settings = {};
var element = document.getElementById('kalender');
caleandar(element, events, settings);
