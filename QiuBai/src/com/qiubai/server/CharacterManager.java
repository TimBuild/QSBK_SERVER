package com.qiubai.server;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.qiubai.entity.Character;
import com.qiubai.tool.ParseDate;

public class CharacterManager {
	public List<Character> getByUrl(String url) {

		List<Character> characters = new ArrayList<Character>();
		Character character;
		ParseDate parseDate = new ParseDate();
		String parseHtml = ParseHtml.getHtmlContent(url, "utf-8");
		Document doc = Jsoup.parse(parseHtml);
		Elements contents = doc
				.getElementsByAttributeValue("class", "tieziBox");
		String char_context, char_title;
		for (Element content : contents) {
			Elements element_context = content.getElementsByAttributeValue(
					"class", "imgbox");
			Elements element_title = content.getElementsByAttributeValue(
					"class", "tieTitle");
			// System.out.println(element.text());
			// System.out.println(element.get(0).getElementsByTag("img"));
			char_context = element_context.get(0)
					.getElementsByAttributeValue("class", "humordatacontent")
					.get(0).removeClass("watermark").text();
			char_title = element_title.get(0).getElementsByTag("a").get(0)
					.text();

			if (!char_context.startsWith("@")) {
				char_context = char_context.replace("@捧腹网", "");
//				System.out.println(char_title);
//				System.out.println(char_context);
//				System.out.println("---------------------------");
				character = new Character();
				character.setChar_title(char_title.trim());
				character.setChar_context(char_context.trim());
				character.setChar_time(parseDate.DateToString(new Date()));

				characters.add(character);

			}

		}
		return characters;

	}

	/*public static void main(String[] args) {
		CharacterManager cm = new CharacterManager();
		List<Character> ch = cm
				.getByUrl("http://www.pengfu.com/xiaohua_1.html");
		System.out.println(ch.get(1).getChar_context());

	}*/
}
