import java.util.*;
import java.util.stream.Collectors;

/**
 * Amazon OA '19 Favorite Genres
 */

public class FavoriteGenres {
    public static Map<String, List<String>> favoriteGenres(Map<String, List<String>> userSongs,
                                                           Map<String, List<String>> songGenres) {
        Map<String, String> inverseSongGenres = new HashMap<>();
        for (Map.Entry<String, List<String>> entry : songGenres.entrySet()) {
            String genre = entry.getKey();
            List<String> songs = entry.getValue();

            for (String song : songs) {
                inverseSongGenres.put(song, genre);
            }
        }

        Map<String, Map<String, Integer>> userGenres = new HashMap<>();

        for (Map.Entry<String, List<String>> entry : userSongs.entrySet()) {
            String user = entry.getKey();
            Map<String, Integer> userPref = new HashMap<>();

            for (String song : entry.getValue()) {
                String genre = inverseSongGenres.get(song);
                userPref.put(genre, userPref.getOrDefault(genre, 0) + 1);
            }

            userGenres.put(user, userPref);
        }

        Map<String, List<String>> favoriteGenre = new HashMap<>();
        for (Map.Entry<String, Map<String, Integer>> userFavs : userGenres.entrySet()) {
            int max = Collections.max(userFavs.getValue().entrySet(), Comparator.comparing(Map.Entry::getValue)).getValue();

            List<String> userFavGenreList = userFavs.getValue().entrySet().stream()
                    .filter(entry -> entry.getValue() == max)
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList());

            favoriteGenre.put(userFavs.getKey(), userFavGenreList);
        }
        return favoriteGenre;
    }

    public static void main(String[] args) {
        Map<String, List<String>> userSongs = new HashMap<>();
        String[] dll = new String[]{"song1", "song2", "song3", "song4", "song8"};
        String[] ell = new String[]{"song5", "song6", "song7"};
        List<String> dl = new ArrayList<>(Arrays.asList(dll));
        List<String> el = new ArrayList<>(Arrays.asList(ell));
        userSongs.put("David", dl);
        userSongs.put("Emma", el);

        Map<String, List<String>> songGenres = new HashMap<>();
        String[] rll = new String[]{"song1", "song3"};
        String[] dsll = new String[]{"song7"};
        String[] tll = new String[]{"song2", "song4"};
        String[] pll = new String[]{"song5", "song6"};
        String[] jll = new String[]{"song8", "song9"};
        List<String> rl = new ArrayList<>(Arrays.asList(rll));
        List<String> dsl = new ArrayList<>(Arrays.asList(dsll));
        List<String> tl = new ArrayList<>(Arrays.asList(tll));
        List<String> pl = new ArrayList<>(Arrays.asList(pll));
        List<String> jl = new ArrayList<>(Arrays.asList(jll));
        songGenres.put("Rock", rl);
        songGenres.put("Dubstep", dsl);
        songGenres.put("Techno", tl);
        songGenres.put("Pop", pl);
        songGenres.put("Jazz", jl);

        Map<String, List<String>> result = FavoriteGenres.favoriteGenres(userSongs, songGenres);
        System.out.println(result);

        Map<String, List<String>> userSongs2 = new HashMap<>();
        String[] dlll = new String[]{"song1", "song2"};
        String[] elll = new String[]{"song3", "song4"};
        List<String> dllll = new ArrayList<>(Arrays.asList(dlll));
        List<String> ellll = new ArrayList<>(Arrays.asList(elll));
        userSongs.put("David", dllll);
        userSongs.put("Emma", ellll);
        Map<String, List<String>> songGenres2 = new HashMap<>();

        Map<String, List<String>> result2 = FavoriteGenres.favoriteGenres(userSongs2, songGenres2);
        System.out.println(result2);
    }
}
