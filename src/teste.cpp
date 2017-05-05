#include <SFML/Audio.hpp>
#include <SFML/Graphics.hpp>

int main(){
	// create de main window
	sf::RenderWindow window(sf::VideoMode(800, 600), "Teste SFML");

	// load a music play
	sf::Music music;
	if(!music.openFromFile("/home/tadasoft/Música/musica.ogg")){
		return EXIT_FAILURE;
	}

	// play music
	music.play();

	// start game loop
	while(window.isOpen()){
		// process events
		sf::Event event;
		while(window.pollEvent(event)){
			// close window exit
			if(event.type == sf::Event::Closed){
				window.close();
			}
		}

		// clear screen
		window.clear();

		// update window
		window.display();
	}

	return EXIT_SUCCESS;
}