package Tema1Ejer5.StarWars;

public interface CharactersDAO {
    /**
     * Comprueba que el archivo esté vacío
     *
     * @return true si el fichero está vacío
     */
    public boolean estaVacio();


    /**
     * Añade un nuevo elemento al CSV a menos que esté presente ya
     *
     * @param characters a añadir al CSV
     */
    public void addCSV(Characters characters);

    /**
     * Actualiza el elememento con el mismo Name que el parámetro
     *
     * @param characters a actualizar
     */
    public void updateCSV(Characters characters);


    /**
     * Imprime por pantalla el CSV con el siguiente formato:
     * Name: <name>
     * Gender: <gender>
     * Birth Year: <birth_year>
     * Height: <height>
     * Mass: <mass>
     * Hair Color: <hair_color>
     * Skin Color: <skin_color>
     * Eye Color: <eye_color>
     * Planet: <planet>
     * Species: <species>
     */
    public void leerCSV();

    /**
     * Borra el personaje que comparta el nombre
     * @param characters A borrar del CSV
     *
     * @return true si se ha borrado de manera exitosa
     */
    public boolean deleteCSV(Characters characters);


    /**
     * Devuelve por pantalla los personajes cuyo nombre se asemeje al del parametro text
     * @param text Palabras clave para buscar
     */
    public void findCSV(String text);
}
