package eu.janinko.Andaria.ultimasdk;

import eu.janinko.Andaria.ultimasdk.files.Anims;
import eu.janinko.Andaria.ultimasdk.files.Arts;
import eu.janinko.Andaria.ultimasdk.files.CliLocs;
import eu.janinko.Andaria.ultimasdk.files.Gumps;
import eu.janinko.Andaria.ultimasdk.files.Hues;
import eu.janinko.Andaria.ultimasdk.files.Statics;
import eu.janinko.Andaria.ultimasdk.files.TileData;
import eu.janinko.Andaria.ultimasdk.files.Verdata;
import eu.janinko.Andaria.ultimasdk.files.anims.Anim;
import eu.janinko.Andaria.ultimasdk.files.anims.Frame;
import eu.janinko.Andaria.ultimasdk.files.arts.Art;
import eu.janinko.Andaria.ultimasdk.files.cliloc.CliLoc;
import eu.janinko.Andaria.ultimasdk.files.gumps.Gump;
import eu.janinko.Andaria.ultimasdk.files.hues.Hue;
import eu.janinko.Andaria.ultimasdk.files.statics.Static;
import eu.janinko.Andaria.ultimasdk.files.tiledata.ItemData;
import eu.janinko.Andaria.ultimasdk.files.tiledata.LandData;
import eu.janinko.Andaria.ultimasdk.files.tiledata.TileFlag;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.imageio.ImageIO;

/**
 *
 * @author jbrazdil
 */
public class UltimaSDK {
	public static final String uopath="/home/jbrazdil/Ultima/hra/";

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {
		File tiledatamul = new File(uopath + "tiledata.mul");
		File tiledatamul2 = new File(uopath + "tiledata.mul");
		File gumpidx = new File(uopath + "gumpidx.mul");
		File gumpart = new File(uopath + "gumpart.mul");
		File animidx = new File(uopath + "anim.idx");
		File animmul = new File(uopath + "anim.mul");
		File artidx = new File(uopath + "artidx.mul");
		File artmul = new File(uopath + "art.mul");
		File huesmul = new File(uopath + "hues.mul");
		File huesmul2 = new File("/home/janinko/Stažené/hues.mul");
		File staidx0 = new File(uopath + "staidx0.mul");
		File statics0 = new File(uopath + "statics0.mul");
		File clilocEnu = new File(uopath + "cliloc.enu");
		//File verdatamul = new File(uopath + "verdata.mul");

		TileData tiledata = new TileData(new FileInputStream(tiledatamul));
		TileData tiledata2 = new TileData(new FileInputStream(tiledatamul2));
		Statics statics = new Statics(new FileInputStream(staidx0), statics0);
		Gumps gumps = new Gumps(new FileInputStream(gumpidx), gumpart);
		Hues hues = new Hues(new FileInputStream(huesmul));
		//Hues hues2 = new Hues(new FileInputStream(huesmul2));
		Arts arts = new Arts(new FileInputStream(artidx), artmul);
		CliLocs cliLocs = new CliLocs(new FileInputStream(clilocEnu));
		//Verdata verdata = new Verdata(new FileInputStream(verdatamul));

		Path path = Paths.get("/tmp/charsets.scp");
		InputStream bc = Files.newInputStream(path);
		int b = bc.read();
		while(b >= 0){
			if(b > 127){
				System.out.printf("%x", b);
			}else{
				System.out.print((char) b);
			}
			b = bc.read();
		}


	}

}
