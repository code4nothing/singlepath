using System.Collections.Generic;

namespace SinglePath
{
	public class FieldsToFetch
	{
		private readonly HashSet<string> _ensuredFieldNames;
		private readonly HashSet<string> _fieldsToFetch;

	    public FieldsToFetch()
	    {
            _fieldsToFetch = new HashSet<string>();
            _ensuredFieldNames = new HashSet<string>();
	    }

	    public IEnumerable<string> Fields
		{
			get
			{
				HashSet<string> fieldsWeMustReturn = new HashSet<string>(_ensuredFieldNames);
			    
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
		    return _fieldsToFetch;
		}

	    public void EnsureHasField(string ensuredFieldName)
		{
			_ensuredFieldNames.Add(ensuredFieldName);
		}
	}
}
