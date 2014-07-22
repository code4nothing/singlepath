using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace SinglePath
{
	public class FieldsToFetch
	{
		private HashSet<string> ensuredFieldNames;
		private readonly HashSet<string> fieldsToFetch;

		public IEnumerable<string> Fields
		{
			get
			{
				HashSet<string> fieldsWeMustReturn = ensuredFieldNames == null
														? new HashSet<string>()
														: new HashSet<string>(ensuredFieldNames);
				foreach (var fieldToReturn in GetFieldsToReturn())
				{
					fieldsWeMustReturn.Remove(fieldToReturn);
					yield return fieldToReturn;
				}

				foreach (var field in fieldsWeMustReturn)
				{
					yield return field;
				}
			}
		}

		private IEnumerable<string> GetFieldsToReturn()
		{
			if (fieldsToFetch == null)
				yield break;
			foreach (var field in fieldsToFetch)
			{
				yield return field;
			}
		}

		public void EnsureHasField(string ensuredFieldName)
		{
			if (ensuredFieldNames == null)
				ensuredFieldNames = new HashSet<string>();
			ensuredFieldNames.Add(ensuredFieldName);
		}
	}
}
