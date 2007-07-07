/*
 * Projet		commun
 * Location     $URL$
 * Version      $Rev$
 * Created	    Oct 20, 2004
 * Modifié      $Date$
 * Modificateur $Author$
 * ©2004 Franqus 
 */
package dominicm.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author Dominicm
 */
public class FileUtils
{
    public static String arrayToString(String[] string)
    {
        StringBuffer contenu = new StringBuffer();
        for (int ii = 0; ii < string.length; ii++)
        {
            contenu.append(string[ii]);
        }
        return contenu.toString();
    }

    public static String[] readFile(File fileName) throws Exception
    {
        return (String[]) extractLines(fileName).toArray(new String[0]);
    }

    public static String[] readFile(String fileName) throws Exception
    {
        return (String[]) extractLines(new File(fileName)).toArray(new String[0]);
    }

    /**
     * Retourne le contenu intégral d'un fichier ligne par ligne en conservant
     * les ligne vide et les espace en fin de ligne.
     * 
     * @param fileName
     * @return ArrayList des lignes
     * @throws Exception
     */
    public static List<String> extractLines(File fileName) throws Exception
    {
        return extractLines(fileName, false, false);
    }

    public static List extractLines(String fileName) throws Exception
    {
        return extractLines(fileName, false, false);
    }

    
    /**
     * Retourn le contenu d'un fichier ligne par ligne.
     * 
     * @param fileName
     * @param suppressWhiteLine =
     *            true si on veux supprimer les lignes vides.
     * @param trim =
     *            true si on veux supprimer les espaces aux extremités des
     *            lignes.
     * @return ArrayList des lignes
     * @throws Exception
     */
    public static List<String> extractLines(File fileName, boolean suppressWhiteLine, boolean trim)
            throws Exception
    {
        List<String> fichier = new ArrayList<String>();

        try
        {
            FileInputStream fis = new FileInputStream(fileName);
            BufferedInputStream bis = new BufferedInputStream(fis);
            BufferedReader br = new BufferedReader(new InputStreamReader(bis));

            String s;
            while ((s = br.readLine()) != null)
            {
                if (!(suppressWhiteLine && s.trim().length() < 1))
                {
                    if (trim)
                    {
                        s = s.trim();
                    }
                    fichier.add(s);
                }
            }
            br.close();
        }
        catch (FileNotFoundException fnfe)
        {
            //logger.error("Fichier '" + fileName + "' non trouvé", fnfe);
            throw new Exception(fnfe);
        }
        catch (IOException ioe)
        {
            //logger.error("Erreur io pour le fichier '" + fileName + "'",
            // ioe);
            throw new Exception(ioe);
        }
        return fichier;
    }

    public static void collectionToFile(Collection<String> lignes, String fileName)
    {
        try
        {
            //FileOutputStream fos = new FileOutputStream(fileName);
            //BufferedOutputStream bos = new BufferedOutputStream(fos);
            FileWriter fw = new FileWriter(fileName);
            BufferedWriter bw = new BufferedWriter(fw);

            for ( String ligne : lignes )
            {
                bw.write(ligne + "\r\n");
            }
            bw.close();

        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static List extractLines(String fileName, boolean suppressWhiteLine, boolean trim)
            throws Exception
    {
        return extractLines(new File(fileName), suppressWhiteLine, trim);
    }

    /**
     * @param contenus
     * @param folder
     * @throws ProcessorException
     */
    public static void listFiles(List<File> contenus, File folder)
    {
        String[] fichiers = folder.list();
        if (fichiers != null)
        {
            for (int ii = 0; ii < fichiers.length; ii++)
            {
                String fichier = fichiers[ii];
                File file = new File(folder, fichier);
                if (file.isDirectory())
                {
                    listFiles(contenus, file);
                }
                else if (file.isFile())
                {
                    contenus.add(file);
                }
            }
        }
    }

    public static boolean delete(File file)
    {
        if (file.exists())
        {
            if (file.isDirectory())
            {
                File[] files = file.listFiles();
                boolean succes = true;
                for (int i = 0; i < files.length; i++)
                {
                    //File subFile = new File(files[i].toString());
                    //succes = delete(subFile);
                    succes = delete(files[i]);

                }
                if (succes)
                {
                    // suppression du dossier
                    return file.delete();
                }
                return false;
            }
            else
            { // supprime le dossier
                return file.delete();
            }
        }
        else
        {
            return false;
        }
    }

    /**
     * Copie un fichier bytes par bytes
     * 
     * @param fileSource
     * @param fileDestination
     * @throws IOException
     */
    public static void copyFile(File fileSource, File fileDestination) throws IOException
    {
        // Copies src file to dst file.
        // If the dst file does not exist, it is created
        InputStream in = new FileInputStream(fileSource);
        OutputStream out = new FileOutputStream(fileDestination);

        // Transfer bytes from in to out
        byte[] buf = new byte[1024];
        int len;
        while ((len = in.read(buf)) > 0)
        {
            out.write(buf, 0, len);
        }
        in.close();
        out.close();
    }

    /**
     * Copie les fichiers et dossiers de façon récursive après avoir supprimé le
     * contenu de folderDestination.
     * 
     * @param folderSource
     * @param folderDestination
     * @throws IOException
     */
    public static void cleanCopy(File folderSource, File folderDestination) throws IOException
    {
        // suppression du dossier
        if (folderDestination.exists())
        {
            delete(folderDestination);
        }

        copy(folderSource, folderDestination);
    }

    /**
     * Copie les fichiers et dossiers de façon récursive.
     * 
     * @param folderSource
     * @param folderDestination
     * @throws IOException
     */
    public static void copy(File folderSource, File folderDestination) throws IOException
    {
        // création du dossier s'il est inexistant
        if (!folderDestination.exists())
        {
            folderDestination.mkdirs();
        }

        File subItems[] = folderSource.listFiles();
        for (int ii = 0; ii < subItems.length; ii++)
        {
            File source = new File(folderSource + "/" + subItems[ii].getName());
            File destination = new File(folderDestination + "/" + subItems[ii].getName());

            if (subItems[ii].isDirectory())
            {
                copy(source, destination);
            }
            else if (subItems[ii].isFile())
            {
                copyFile(source, destination);
            }
        }
    }

    public static void main(String[] args)
    {
        if (false)
        {
            Runtime rt = Runtime.getRuntime();
    
            try
            {
                System.out.println("copie...");
                String[] command = { "xcopy", "C:\\dossier\\patate\\docbases.jar", "C:\\docbases.jar", "/y", "/s", "/e" };
                Process ps = rt.exec(command);
    
                ps.waitFor();
    
                if (ps.exitValue() == 0)
                {
                    System.out.println("copie terminée");
                }
                else
                {
                    System.out.println("erreur code : " + new String(ps.exitValue() + ""));
                }
    
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        
        
        try
        {
            Map map = fileCSV2map("C:/Documents and Settings/dominicm.FRANQUS-SHER/Bureau/Conjugaison_fichier_de_traitement2.tab", "\t", 1);
            Map croire = (Map) map.get("croire.ad");
            System.out.println(croire.get("modèle"));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    /**
     * Transférer un fichier de "clé=valeur" vers une map.
     * @param mapFile
     * @param separateur
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public static Map<String, String> file2map(String mapFile, String separateur) throws Exception
    {
        Map<String, String> map;
        List<String> listPRE_1 = FileUtils.extractLines(mapFile);
        map = new HashMap<String, String>();
        for (String chaine : listPRE_1)
        {
            String[] splitted = chaine.split(separateur);
            map.put(splitted[0], splitted[1]);
            
        }
        return map;
    }
    
    /**
     * Transfert un fichier du type CSV ou TAB vers une map.
     * <br>
     * <br>Format du fichier
     * <br>nom_fichier  | modèle        | auxiliaire<br>
     * <br>-------------|---------------|--------------
     * <br>croire.ad    | 80-croire     | 4-composés_avoir
     * <br>accroire.ad  | aucun_renvoi  |
     * <br>
     * <br>Va donner une map
     * <br>croire.ad    | map [ modèle=80-croire, auxiliaire=4-composés_avoir ]
     * <br>accroire.ad  | map [ modèle=aucun_renvoi, auxiliaire= ]
     * <br>
     * @param mapFile
     * @param separateur (ex. : "\t") 
     * @param indexCle (ex. : 0 pour la colonne nom_fichier)
     * @return
     * @throws Exception
     */
    public static Map<String, Map> fileCSV2map(String mapFile, String separateur, int indexCle) throws Exception
    {
        Map<String, Map> map = new HashMap<String, Map>();
        List<String> titresColonnes = new ArrayList<String>();

        List<String> lignes = FileUtils.extractLines(mapFile);
        boolean premiereLigne = true;
        for (String ligne : lignes)
        {
            // stockage des noms de colonne
            if (premiereLigne)
            {
                // nom_fichier | modèle | auxiliaire
                String[] nomsDeColonnes = ligne.split(separateur);
                for (String nomDeColonnes : nomsDeColonnes)
                {
                    titresColonnes.add(nomDeColonnes);
                }
                premiereLigne = false;
            }
            else
            {
                // croire.ad | 80-croire | 4-composés_avoir
                String[] ligneContenu = ligne.split(separateur);
                
                Map<String, String> colonnes = new HashMap<String, String>();  
                int indexCol = 0;
                for (String element : ligneContenu)
                {
                    // stocker (nom_fichier, croire.ad)
                    colonnes.put(titresColonnes.get(indexCol), element);
                    indexCol++;
                }
                String nomDeLaCle = titresColonnes.get(indexCle);
                map.put(colonnes.get(nomDeLaCle), colonnes);
            }
        }
        return map;
    }
    

    @SuppressWarnings("unchecked")
    public static Map<String, List> file2map2dimensions(String mapFile, String separateur) throws Exception
    {
        Map<String, List> map;
        List<String> liste;
        
        List<String> listPRE_1 = FileUtils.extractLines(mapFile);
        map = new HashMap<String, List>();
        for (String chaine : listPRE_1)
        {
            String[] splitted = chaine.split(separateur);
            String cle = splitted[0];
            String valeur = splitted[1];

            // ajouter la valeur à la map
            if (map.containsKey(cle))
            {
                // si la cle existe déjà dans la map, on prend la liste existante
                liste = map.get(cle);
            }
            else
            {
                // par contre si elle n'existe pas, on crée une nouvelle liste
                liste = new ArrayList<String>();
                map.put(cle, liste);
            }
            liste.add(valeur);
            
        }
        return map;
    }

    public static void list2File(List<String> nouvelleListe, String file) throws IOException
    {
        FileWriter fw = new FileWriter(new File(file));
        for (String nouvelItem : nouvelleListe)
        {
            fw.write(nouvelItem + "\n");
        }
        fw.close();
    }
}