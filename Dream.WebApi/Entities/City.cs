using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Threading.Tasks;

namespace Dream.WebApi.Entities
{
    [Table("tblCities")]
    public class City
    {
        [Key]
        public long Id { get; set; }
        [Required, StringLength(255)]
        public string Name { get; set; }

    }
}
