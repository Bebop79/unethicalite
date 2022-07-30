import java.awt.Shape;
import net.runelite.mapping.ObfuscatedName;
import java.awt.image.Raster;
import java.awt.image.DirectColorModel;
import java.util.Hashtable;
import net.runelite.mapping.Implements;
import java.awt.image.DataBufferInt;
import java.awt.Point;
import java.awt.Image;
import java.awt.image.BufferedImage;
import net.runelite.mapping.ObfuscatedSignature;
import java.awt.image.WritableRaster;
import java.awt.Graphics;
import java.awt.Component;
import net.runelite.mapping.Export;
@ObfuscatedName("af")
@Implements("RasterProvider")
public final class RasterProvider extends AbstractRasterProvider {
	@ObfuscatedName("o")
	@Export("component")
	Component component;

	@ObfuscatedName("q")
	@Export("image")
	Image image;

	RasterProvider(int var1, int var2, Component var3) {
		super.width = var1;
		super.height = var2;
		super.pixels = new int[var2 * var1 + 1];
		DataBufferInt var4 = new DataBufferInt(super.pixels, super.pixels.length);
		DirectColorModel var5 = new DirectColorModel(32, 16711680, 65280, 255);
		WritableRaster var6 = Raster.createWritableRaster(var5.createCompatibleSampleModel(super.width, super.height), var4, ((Point) (null)));
		this.image = new BufferedImage(var5, var6, false, new Hashtable());
		this.setComponent(var3);
		this.apply();
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(descriptor = "(Ljava/awt/Component;I)V", garbageValue = "-1638617241")
	@Export("setComponent")
	final void setComponent(Component var1) {
		this.component = var1;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(descriptor = "(III)V", garbageValue = "-490851442")
	@Export("drawFull")
	public final void drawFull(int var1, int var2) {
		this.drawFull0(this.component.getGraphics(), var1, var2);
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(descriptor = "(IIIII)V", garbageValue = "2472356")
	@Export("draw")
	public final void draw(int var1, int var2, int var3, int var4) {
		this.draw0(this.component.getGraphics(), var1, var2, var3, var4);
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(descriptor = "(Ljava/awt/Graphics;III)V", garbageValue = "1986111684")
	@Export("drawFull0")
	final void drawFull0(Graphics var1, int var2, int var3) {
		try {
			var1.drawImage(this.image, var2, var3, this.component);
		} catch (Exception var5) {
			this.component.repaint();
		}
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(descriptor = "(Ljava/awt/Graphics;IIIII)V", garbageValue = "857748964")
	@Export("draw0")
	final void draw0(Graphics var1, int var2, int var3, int var4, int var5) {
		try {
			Shape var6 = var1.getClip();
			var1.clipRect(var2, var3, var4, var5);
			var1.drawImage(this.image, 0, 0, this.component);
			var1.setClip(var6);
		} catch (Exception var7) {
			this.component.repaint();
		}
	}
}