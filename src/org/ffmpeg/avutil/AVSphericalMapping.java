package org.ffmpeg.avutil;
import org.bridj.BridJ;
import org.bridj.IntValuedEnum;
import org.bridj.Pointer;
import org.bridj.StructObject;
import org.bridj.ann.Field;
import org.bridj.ann.Library;
import org.ffmpeg.avutil.AvutilLibrary.AVSphericalProjection;
/**
 * <i>native declaration : libavutil/spherical.h:116</i><br>
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> or <a href="http://bridj.googlecode.com/">BridJ</a> .
 */
@Library("avutil") 
public class AVSphericalMapping extends StructObject {
	static {
		BridJ.register();
	}
	/**
	 * Projection type.<br>
	 * C type : AVSphericalProjection
	 */
	@Field(0) 
	public IntValuedEnum<AVSphericalProjection > projection() {
		return this.io.getEnumField(this, 0);
	}
	/**
	 * Projection type.<br>
	 * C type : AVSphericalProjection
	 */
	@Field(0) 
	public AVSphericalMapping projection(IntValuedEnum<AVSphericalProjection > projection) {
		this.io.setEnumField(this, 0, projection);
		return this;
	}
	/**
	 * @name Initial orientation<br>
	 * @{<br>
	 * There fields describe additional rotations applied to the sphere after<br>
	 * the video frame is mapped onto it. The sphere is rotated around the<br>
	 * viewer, who remains stationary. The order of transformation is always<br>
	 * yaw, followed by pitch, and finally by roll.<br>
	 * * The coordinate system matches the one defined in OpenGL, where the<br>
	 * forward vector (z) is coming out of screen, and it is equivalent to<br>
	 * a rotation matrix of R = r_y(yaw) * r_x(pitch) * r_z(roll).<br>
	 * * A positive yaw rotates the portion of the sphere in front of the viewer<br>
	 * toward their right. A positive pitch rotates the portion of the sphere<br>
	 * in front of the viewer upwards. A positive roll tilts the portion of<br>
	 * the sphere in front of the viewer to the viewer's right.<br>
	 * * These values are exported as 16.16 fixed point.<br>
	 * * See this equirectangular projection as example:<br>
	 * * @code{.unparsed}<br>
	 *                   Yaw<br>
	 *     -180           0           180<br>
	 *   90 +-------------+-------------+  180<br>
	 *      |             |             |                  up<br>
	 * P    |             |             |                 y|    forward<br>
	 * i    |             ^             |                  |   /z<br>
	 * t  0 +-------------X-------------+    0 Roll        |  /<br>
	 * c    |             |             |                  | /<br>
	 * h    |             |             |                 0|/_____right<br>
	 *      |             |             |                        x<br>
	 *  -90 +-------------+-------------+ -180<br>
	 * * X - the default camera center<br>
	 * ^ - the default up vector<br>
	 * @endcode<br>
	 * < Rotation around the up vector [-180, 180].
	 */
	@Field(1) 
	public int yaw() {
		return this.io.getIntField(this, 1);
	}
	/**
	 * @name Initial orientation<br>
	 * @{<br>
	 * There fields describe additional rotations applied to the sphere after<br>
	 * the video frame is mapped onto it. The sphere is rotated around the<br>
	 * viewer, who remains stationary. The order of transformation is always<br>
	 * yaw, followed by pitch, and finally by roll.<br>
	 * * The coordinate system matches the one defined in OpenGL, where the<br>
	 * forward vector (z) is coming out of screen, and it is equivalent to<br>
	 * a rotation matrix of R = r_y(yaw) * r_x(pitch) * r_z(roll).<br>
	 * * A positive yaw rotates the portion of the sphere in front of the viewer<br>
	 * toward their right. A positive pitch rotates the portion of the sphere<br>
	 * in front of the viewer upwards. A positive roll tilts the portion of<br>
	 * the sphere in front of the viewer to the viewer's right.<br>
	 * * These values are exported as 16.16 fixed point.<br>
	 * * See this equirectangular projection as example:<br>
	 * * @code{.unparsed}<br>
	 *                   Yaw<br>
	 *     -180           0           180<br>
	 *   90 +-------------+-------------+  180<br>
	 *      |             |             |                  up<br>
	 * P    |             |             |                 y|    forward<br>
	 * i    |             ^             |                  |   /z<br>
	 * t  0 +-------------X-------------+    0 Roll        |  /<br>
	 * c    |             |             |                  | /<br>
	 * h    |             |             |                 0|/_____right<br>
	 *      |             |             |                        x<br>
	 *  -90 +-------------+-------------+ -180<br>
	 * * X - the default camera center<br>
	 * ^ - the default up vector<br>
	 * @endcode<br>
	 * < Rotation around the up vector [-180, 180].
	 */
	@Field(1) 
	public AVSphericalMapping yaw(int yaw) {
		this.io.setIntField(this, 1, yaw);
		return this;
	}
	/** < Rotation around the right vector [-90, 90]. */
	@Field(2) 
	public int pitch() {
		return this.io.getIntField(this, 2);
	}
	/** < Rotation around the right vector [-90, 90]. */
	@Field(2) 
	public AVSphericalMapping pitch(int pitch) {
		this.io.setIntField(this, 2, pitch);
		return this;
	}
	/** < Rotation around the forward vector [-180, 180]. */
	@Field(3) 
	public int roll() {
		return this.io.getIntField(this, 3);
	}
	/** < Rotation around the forward vector [-180, 180]. */
	@Field(3) 
	public AVSphericalMapping roll(int roll) {
		this.io.setIntField(this, 3, roll);
		return this;
	}
	/**
	 * @name Bounding rectangle<br>
	 * @anchor bounding<br>
	 * @{<br>
	 * These fields indicate the location of the current tile, and where<br>
	 * it should be mapped relative to the original surface. They are<br>
	 * exported as 0.32 fixed point, and can be converted to classic<br>
	 * pixel values with av_spherical_bounds().<br>
	 * * @code{.unparsed}<br>
	 *      +----------------+----------+<br>
	 *      |                |bound_top |<br>
	 *      |            +--------+     |<br>
	 *      | bound_left |tile    |     |<br>
	 *      +<---------->|        |<--->+bound_right<br>
	 *      |            +--------+     |<br>
	 *      |                |          |<br>
	 *      |    bound_bottom|          |<br>
	 *      +----------------+----------+<br>
	 * @endcode<br>
	 * * If needed, the original video surface dimensions can be derived<br>
	 * by adding the current stream or frame size to the related bounds,<br>
	 * like in the following example:<br>
	 * * @code{c}<br>
	 *     original_width  = tile->width  + bound_left + bound_right;<br>
	 *     original_height = tile->height + bound_top  + bound_bottom;<br>
	 * @endcode<br>
	 * * @note These values are valid only for the tiled equirectangular<br>
	 *       projection type (@ref AV_SPHERICAL_EQUIRECTANGULAR_TILE),<br>
	 *       and should be ignored in all other cases.<br>
	 * < Distance from the left edge
	 */
	@Field(4) 
	public int bound_left() {
		return this.io.getIntField(this, 4);
	}
	/**
	 * @name Bounding rectangle<br>
	 * @anchor bounding<br>
	 * @{<br>
	 * These fields indicate the location of the current tile, and where<br>
	 * it should be mapped relative to the original surface. They are<br>
	 * exported as 0.32 fixed point, and can be converted to classic<br>
	 * pixel values with av_spherical_bounds().<br>
	 * * @code{.unparsed}<br>
	 *      +----------------+----------+<br>
	 *      |                |bound_top |<br>
	 *      |            +--------+     |<br>
	 *      | bound_left |tile    |     |<br>
	 *      +<---------->|        |<--->+bound_right<br>
	 *      |            +--------+     |<br>
	 *      |                |          |<br>
	 *      |    bound_bottom|          |<br>
	 *      +----------------+----------+<br>
	 * @endcode<br>
	 * * If needed, the original video surface dimensions can be derived<br>
	 * by adding the current stream or frame size to the related bounds,<br>
	 * like in the following example:<br>
	 * * @code{c}<br>
	 *     original_width  = tile->width  + bound_left + bound_right;<br>
	 *     original_height = tile->height + bound_top  + bound_bottom;<br>
	 * @endcode<br>
	 * * @note These values are valid only for the tiled equirectangular<br>
	 *       projection type (@ref AV_SPHERICAL_EQUIRECTANGULAR_TILE),<br>
	 *       and should be ignored in all other cases.<br>
	 * < Distance from the left edge
	 */
	@Field(4) 
	public AVSphericalMapping bound_left(int bound_left) {
		this.io.setIntField(this, 4, bound_left);
		return this;
	}
	/** < Distance from the top edge */
	@Field(5) 
	public int bound_top() {
		return this.io.getIntField(this, 5);
	}
	/** < Distance from the top edge */
	@Field(5) 
	public AVSphericalMapping bound_top(int bound_top) {
		this.io.setIntField(this, 5, bound_top);
		return this;
	}
	/** < Distance from the right edge */
	@Field(6) 
	public int bound_right() {
		return this.io.getIntField(this, 6);
	}
	/** < Distance from the right edge */
	@Field(6) 
	public AVSphericalMapping bound_right(int bound_right) {
		this.io.setIntField(this, 6, bound_right);
		return this;
	}
	/** < Distance from the bottom edge */
	@Field(7) 
	public int bound_bottom() {
		return this.io.getIntField(this, 7);
	}
	/** < Distance from the bottom edge */
	@Field(7) 
	public AVSphericalMapping bound_bottom(int bound_bottom) {
		this.io.setIntField(this, 7, bound_bottom);
		return this;
	}
	/**
	 * Number of pixels to pad from the edge of each cube face.<br>
	 * * @note This value is valid for only for the cubemap projection type<br>
	 *       (@ref AV_SPHERICAL_CUBEMAP), and should be ignored in all other<br>
	 *       cases.
	 */
	@Field(8) 
	public int padding() {
		return this.io.getIntField(this, 8);
	}
	/**
	 * Number of pixels to pad from the edge of each cube face.<br>
	 * * @note This value is valid for only for the cubemap projection type<br>
	 *       (@ref AV_SPHERICAL_CUBEMAP), and should be ignored in all other<br>
	 *       cases.
	 */
	@Field(8) 
	public AVSphericalMapping padding(int padding) {
		this.io.setIntField(this, 8, padding);
		return this;
	}
	public AVSphericalMapping() {
		super();
	}
	public AVSphericalMapping(Pointer pointer) {
		super(pointer);
	}
}
