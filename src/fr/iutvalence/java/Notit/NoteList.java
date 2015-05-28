package fr.iutvalence.java.Notit;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * A list of Note.
 * 
 * @author G19
 *
 */
public class NoteList
{
	/**
	 * The list of note of the day.
	 */
	private Set<DayNote> listOfDayNote;

	/**
	 * The list of general note.
	 */
	private Set<GeneralNote> listOfGeneralNote;

	/**
	 * The NoteList's constructor who recover the list of general note.
	 * 
	 * @throws IOException
	 */
	public NoteList() throws IOException
	{
		String numTemp = "";
		int numero = 0;
		String title = "";
		String contenu = "";
		this.listOfGeneralNote = new HashSet<GeneralNote>();
		File[] files = arrayOfGeneralNote();

		for (int index = 0; index < files.length; index++)
		{
			numTemp = "";
			numero = 0;
			title = "";
			contenu = "";
			FileReader flux = new FileReader(files[index]);
			int lettre;
			while ((lettre = flux.read()) != 13)
			{
				numTemp += (char) lettre;
			}
			numero = Integer.parseInt(numTemp);
			while ((lettre = flux.read()) != 13)
			{
				title += (char) lettre;
			}
			while ((lettre = flux.read()) != -1)
			{
				contenu += (char) lettre;
			}

			this.listOfGeneralNote.add(new GeneralNote(numero, title, contenu));
		}
	}

	/**
	 * The NoteList's constructor who recover the list of note of a day.
	 * 
	 * @param date
	 * @throws IOException
	 */
	public NoteList(Date date) throws IOException
	{
		String numTemp = "";
		int numero = 0;
		String title = "";
		String contenu = "";
		this.listOfDayNote = new HashSet<DayNote>();
		File[] files = arrayOfDayNote(date);
		if (files != null)
		{
			for (int index = 0; index < files.length; index++)
			{
				numTemp = "";
				numero = 0;
				title = "";
				contenu = "";
				FileReader flux = new FileReader(files[index]);
				int lettre;

				while ((lettre = flux.read()) != 13)
				{
					numTemp += (char) (lettre);
				}
				numero = Integer.parseInt(numTemp);
				while ((lettre = flux.read()) != 13)
				{
					title += (char) lettre;
				}
				while ((lettre = flux.read()) != -1)
				{
					contenu += (char) lettre;
				}
				listOfDayNote.add(new DayNote(numero, title, contenu, date));
			}
		}
	}

	/**
	 * Board of general note.
	 * 
	 * @return files
	 */
	private File[] arrayOfGeneralNote()
	{
		File[] files = null;
		File repertoire = new File("GeneralNotes");
		files = repertoire.listFiles();
		return files;
	}

	/**
	 * board of note of a day.
	 * 
	 * @param date
	 * @return files
	 */
	private File[] arrayOfDayNote(Date date)
	{
		File[] files = null;
		String pathName = "Notes/" + date.get(date.YEAR) + "-"
				+ date.get(date.MONTH) + "-" + date.get(date.DAY_OF_MONTH);
		File repertoire = new File(pathName);
		if (repertoire.exists())
		{
			files = repertoire.listFiles();
		}
		return files;
	}

	/**
	 * Getter to get list of general note.
	 * 
	 * @return listOfGeneralNote
	 */
	public Set<GeneralNote> getlistOfGeneralNote()
	{
		return this.listOfGeneralNote;
	}

	/**
	 * Getter to get list of note of a day.
	 * 
	 * @return listOfDayNote
	 */
	public Set<DayNote> getlistOfDayNote()
	{
		return this.listOfDayNote;
	}
}