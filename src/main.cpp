/*********************************************************************
Date: 09/05/2017
Autor: TadaSoftware
       Junior Tada
       Leonardo Tada
*********************************************************************/

#include <SFML/Graphics/RenderWindow.hpp>
#include <SFML/Window/Event.hpp>

#include <tmxlite/Map.hpp>

#include "SFMLOrthogonalLayer.hpp"

int main()
{
    sf::RenderWindow window(sf::VideoMode(800, 600), "AgroInvestidor");

    tmx::Map map;
    map.load("assets/mapa.tmx");

    MapLayer layerZero(map, 0);

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
        window.display();
    }

    return 0;
}
