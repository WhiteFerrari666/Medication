var datum = new Date()
var jahr = datum.getFullYear()

var tag = datum.getDate()

function monat1(){
    var monat = datum.getMonth()

    if (monat==0) document.write("Januar");
    if (monat==1) document.write("Februar");
    if (monat==2) document.write("März");
    if (monat==3) document.write("April");
    if (monat==4) document.write("Mai");
    if (monat==5) document.write("Juni");
    if (monat==6) document.write("Juli");
    if (monat==7) document.write("August");
    if (monat==8) document.write("September");
    if (monat==9) document.write("Oktober");
    if (monat==10) document.write("November")
    if (monat==11) document.write("Dezember")
}



function wotag(){
    var datum = new Date()
    var wochentag = datum.getDay()

    if (wochentag==0) document.write("Sonntag");
    if (wochentag==1) document.write("Montag");
    if (wochentag==2) document.write("Dienstag");
    if (wochentag==3) document.write("Mittwoch");
    if (wochentag==4) document.write("Donnerstag");
    if (wochentag==5) document.write("Freitag");
    if (wochentag==6) document.write("Samstag");

}

wotag()
document.write(", der ")

document.write(tag,". ")
monat1()
document.write(" ",jahr)
