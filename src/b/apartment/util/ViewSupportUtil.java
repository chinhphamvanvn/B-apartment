package b.apartment.util;

import java.util.Locale;

import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import b.apartment.uploader.ImageUploader;
import net.time4j.Moment;
import net.time4j.PrettyTime;

public class ViewSupportUtil {

	private ImageUploader imageUploader;

	public ViewSupportUtil(ImageUploader imageUploader) {
		this.imageUploader = imageUploader;
	}

	public String gravatarFor(String email) {
		if (StringUtils.isEmpty(email)) {
			return "";
		}
		String gravatarId = DigestUtils.md5DigestAsHex(email.getBytes());
		return "https://secure.gravatar.com/avatar/" + gravatarId + "?s=50";
	}

	public String timeAgoInWords(Locale locale, java.util.Date date) {
		if (date == null) {
			return "";
		}
		return PrettyTime.of(locale).printRelativeInStdTimezone(Moment.from(date.toInstant()));
	}

	public String pluralize(String text, int count) {
		return count + " ";// + Inflector.getInstance().pluralize(text, count);
	}

	public String getImageUrl(String image) {
		return imageUploader.buildImageUpload(image).getUrl();
	}
}
