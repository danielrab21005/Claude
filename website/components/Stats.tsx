const stats = [
  { value: "500+", label: "Houses of Worship" },
  { value: "$2.4M+", label: "Donations Processed" },
  { value: "99.9%", label: "Uptime" },
  { value: "4.9★", label: "Average Rating" },
];

export default function Stats() {
  return (
    <section className="bg-indigo-600 py-12">
      <div className="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8">
        <div className="grid grid-cols-2 md:grid-cols-4 gap-8 text-center">
          {stats.map((s) => (
            <div key={s.label}>
              <p className="text-3xl font-bold text-white">{s.value}</p>
              <p className="text-indigo-200 text-sm mt-1">{s.label}</p>
            </div>
          ))}
        </div>
      </div>
    </section>
  );
}
