using Microsoft.Extensions.Primitives;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Threading.Tasks;

namespace Dream.WebApi.Entities
{
    [Table("tblUniversities")]
    public class University
    {
        [Key]
        public long Id { get; set; }
        [Required, StringLength(255)]
        public string Name { get; set; }

        [StringLength(255)]
        public string Image { get; set; }

        [ForeignKey("City")]
        public long CityId { get; set; }
        public City City { get; set; }

    }
}
