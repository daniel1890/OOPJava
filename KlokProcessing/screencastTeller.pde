Klok deKlok;

void setup() {
  size(400, 300);
  background(255);
  deKlok = new Klok(150, 100, 200);

  deKlok.setTijd(00, 00);
}

void draw() {
  deKlok.tik();
  deKlok.tekenKlok();
  println(deKlok.minutenTeller.waarde);
}
