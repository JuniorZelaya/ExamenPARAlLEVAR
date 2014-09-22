
public class Examenparallevar {

	public static void main(String[] args) {
		static Juego juego; 

		public static void main(String[] args) { 


		int ancho; 
		int alto; 
		int opcion; 
		if(args.length==0){ 
		ancho=alto=10; 
		} 
		else if (args.length==2){ 
		ancho=Intger.parseInt(args[0]); 
		alto=Intger.parseInt(args[1]); 
		} 


		else{ 
		println("Uso:P2[ancho alto]"); 
		System.exit(1); 
		} 

		// Crear juego 

		//menu principal 

		do{ 
		println("Menú principal"); 
		println("1.Nueva"); 
		println("2.Continuar"); 
		println("0.Salir"); 
		print("Opcion (0-2):"); 
		opcion=Teclado.leerInt(); 
		switch(opcion){ 
		case 0: 
		break; 
		case 1: 
		partidaNueva(); 
		break; 
		case 2: 
		continuar(); 
		break; 
		default:; 

		} 
		} 
		while(opcion!=0); 


		nueva();{ 
		crearjugadores(); 
		colocarbarcos(); 
		jugar(); //esto no se porque se pone 

		} 
		continuar();{ 
		jugar(); 
		} 


		}//main 
		private static void crearJugadores(){ 
		string nombre; 
		boolean OK,automatico; 
		int tipo, turno_inicial=0; 
		Jugador jugador; 
		char c; 
		for(int j=0;j<juego.NUM_JUG;j++){ 
		do{ 
		println("jugador"+(j++)); 
		print("tipo (1-Humano;2-Computadora:"); 
		tipo=Teclado.leerInt(); 

		} 
		while((tipo!=1)&&(tipo!=2)); 
		switch(tipo){ 
		case 1://humano 
		print("Nombre:"); 
		nombre=Teclado.leerString(); 
		jugador=juego.crearJugador(j,nombre,false); 
		print("Automático o Manual (A/M)"); 
		c=Teclado.leerchar(); 
		automatico=((c=='A')||(c=='a')); 
		colocarBarcos(jugador,automatico); 
		break; 
		case 2: //computadora 
		jugador=juego.crearJugador(j,"Computadora",true); 
		colocarBarcos(jugador, true); 
		break; 
		} 
		} 

		//swith 
		juego.inicializarTurno(turno_inicial); 
		} 
		private static void colocarBarcos(Jugador jug, boolean automatico){ 
		Barco barco; 
		boolean OK; 
		int x, y, div, tam; 
		for(int b=0;b<jug.listaBarcos.size();b++){ 
		barco=(Barco)jug.listaBarcos.get(i); 

		if(jug.esComputadora||automatico){ 
		jug.tablero.colocarBarco(barco); 
		} 
		else{ 
		do{ 
		jugador.tablero.mostrar(false); 
		println("Barco"+(b+1)+"Tamaño:"+barco.tamaño); 
		print("x="); 
		x=Teclado.leerInt(); 
		print("y="); 
		y=Teclado.leerInt(); 


		if(barco.tamaño==1){ 
		div=1; 
		} 
		else{ 
		print("div(1-2"); 
		div=Teclado.leerInt(); 
		OK=jug.tablero.colocarBarco(barco, x, y, div); 
		if(!OK) 
		println("Error");


		} 
		} 
		private static void jugar(){ 
		int opcion, res; 
		char c; 
		boolean victoria, abortar; 
		Jugador jugador, enemigo; 
		do{ 
		jugador=juego.jugadorTurno(); 
		enemigo=juego.jugadorEnemigo(); 
		println("Turno de:"+jugador.nombre); 
		res=-1; 


		if(jugador.esComputadora){ 
		res=disparo(jugador,enemigo,false); 

		} 
		else{ 
		jugador.tablero.mostrar(false); 
		enemigo.tablero.mostrar(true); 
		print("0-Volver; A-Automatico; M-Manual"); 
		c=Teclado.leerChar(); 
		switch(c){ 
		case'0': 
		abortar=true; 
		break; 
		case'A': 
		res=disparo(jugador,enemigo,false); 
		break; 
		case'M': 
		res=disparo(jugador,enemigo,true); 
		break; 
		default:; 
		} 
		} 
		victoria=enemigo.todosHundidos(); 
		if(!abortar){ 
		println(jugador.resultDisparo); 
		juego.siguienteTurno(); //0-1-0-1 

		} 
		while(!victoria&&!abortar); 

		//} 
		if(victoria){ 
		println("Victoria de"+jugador.nombre); 
		//mostrar tableros 
		//pulsar tecla 

		private static int disparo(Jugador jug, Jugador enemigo, boolean manual){ 
		int res, x=0, y=0; 
		do{ 
		if(manual){ 
		print("x="); 
		x=Teclado.leerInt(); 
		print("y="); 
		y=Teclado.leerInt(); 
		res=jug.disparo(enemigo, x, y); 
		} 
		else{ 
		res=jug.disparo(enemigo); 
		} 
		} 
		while(res<0); 
		return(res); 
		} 
		public Jugador jugadorTurno(){ 
		return(jugadores[turno]); 
		} 
		public Jugador jugadorEnemigo(){ 
		return(jugadores[turno_siguiente]); 
		} 
		public Jugador crearJugador(int j,string nombre,boolean esComputadora){ 
		jugadores[j]=newJugador(nombre,esComputadora,ancho,alto,NUM_BARCO); 
		return(jugadores[j]); 
		} 
	}

}
