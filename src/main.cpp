/*********************************************************************
Date: 09/05/2017
Autor: TadaSoftware
       Junior Tada
       Leonardo Tada
*********************************************************************/

#include <SFML/Graphics/RenderWindow.hpp>
#include <SFML/Graphics/Sprite.hpp>
#include <SFML/Window/Event.hpp>

#include <tmxlite/Map.hpp>

#include "SFMLOrthogonalLayer.hpp"

int main()
{
    sf::RenderWindow window(sf::VideoMode(800, 600), "AgroInvestidor");

    // mapa
    tmx::Map map;
    map.load("assets/mapa.tmx");
    MapLayer layerZero(map, 0);
    // sprite
    sf::Texture texture;
    if (!texture.loadFromFile("assets/sprites/tendatocos.png"))
    {
        // error...
    }
    texture.setSmooth(true);
    sf::Sprite sprite;
    sprite.setTexture(texture);

    while (window.isOpen())
    {
        sf::Event event;
        while (window.pollEvent(event))
        {
            if (event.type == sf::Event::Closed)
                window.close();
        }

        window.clear(sf::Color::Black);
        window.draw(layerZero);
        window.draw(sprite);
        window.display();
    }

    return 0;
}
