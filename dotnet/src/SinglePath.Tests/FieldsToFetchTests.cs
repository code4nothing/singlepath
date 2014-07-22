using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using NUnit.Framework;
using SharpTestsEx;
using SinglePath;

namespace SinglePathTests
{
	[TestFixture]
	class FieldsToFetchTests
	{
		[Test]
		public void EnsureHasField_should_add_a_field()
		{
			var sut = new FieldsToFetch();

			sut.EnsureHasField("foo");

			sut.Fields.Should().Contain("foo");
		}
	}
}
